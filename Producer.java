public class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i); // Produces data and puts it into the buffer
            try {
                Thread.sleep((int) (Math.random() * 2000)); // Sleep for a random time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
