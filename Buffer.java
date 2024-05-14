public class Buffer {
    private int data;
    private boolean available = false;

    public synchronized void produce(int newData) {
        while (available) {
            try {
                wait(); // Wait if buffer is not empty
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        data = newData;
        available = true;
        System.out.println("Produced: " + data);
        notifyAll(); // Notify waiting consumers that data is available
    }

    public synchronized int consume() {
        while (!available) {
            try {
                wait(); // Wait if buffer is empty
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        available = false;
        System.out.println("Consumed: " + data);
        notifyAll(); // Notify waiting producers that buffer is empty
        return data;
    }
}
