import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrimeTaskCalculator extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 100;
    private static final int MIN_RANGE = 2;
    private static final int MAX_RANGE = 10000;

    private JProgressBar progressBar;
    private JButton calculateButton;

    public PrimeTaskCalculator() {
        createView();
    }

    private void createView() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());

        progressBar = new JProgressBar(MIN_RANGE, MAX_RANGE);
        progressBar.setStringPainted(true);
        add(progressBar);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(e -> calculatePrimes());
        add(calculateButton);
    }

    private void calculatePrimes() {
        int range = MAX_RANGE - MIN_RANGE;
        progressBar.setMaximum(range);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new PrimeCalculatorTask(progressBar));

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PrimeTaskCalculator frame = new PrimeTaskCalculator();
            frame.setVisible(true);
        });
    }
}

class PrimeCalculatorTask implements Runnable {
    private JProgressBar progressBar;

    PrimeCalculatorTask(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        for (int number = PrimeTaskCalculator.ALLBITS; number <= PrimeTaskCalculator.ALLBITS; number++) {
            if (isPrime(number)) {
                progressBar.setValue(number);
                progressBar.setString(number + "");
            }
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}