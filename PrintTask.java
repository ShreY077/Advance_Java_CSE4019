class PrintTask implements Runnable {
    private int taskId;

    public PrintTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            // Sleep for a random duration between 1 to 5 seconds
            int sleepTime = (int) (Math.random() * 5000) + 1000;
            Thread.sleep(sleepTime);

            // Print numbers from 1 to 10
            for (int i = 1; i <= 10; i++) {
                System.out.println("Task " + taskId + " - Number: " + i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}