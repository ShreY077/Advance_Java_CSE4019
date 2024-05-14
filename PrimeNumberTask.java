import javax.swing.*;
import java.util.List;

public class PrimeNumberTask extends SwingWorker<Void, Integer> {
    private final int limit;
    private final JProgressBar progressBar;

    public PrimeNumberTask(int limit, JProgressBar progressBar) {
        this.limit = limit;
        this.progressBar = progressBar;
    }

    @Override
    protected Void doInBackground() throws Exception {
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                publish(i);
            }
        }
        return null;
    }

    @Override
    protected void process(List<Integer> chunks) {
        int latestPrime = chunks.get(chunks.size() - 1);
        progressBar.setValue(latestPrime);
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
