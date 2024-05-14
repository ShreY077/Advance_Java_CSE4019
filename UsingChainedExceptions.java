public class UsingChainedExceptions {

    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
            System.out.println("Original cause: " + e.getCause());
        }
    }

    public static void method1() throws Exception {
        try {
            method2();
        } catch (Exception e) {
            // Creating a new exception with a custom message and chaining the original exception
            throw new Exception("Exception in method1", e);
        }
    }

    public static void method2() throws Exception {
        // Simulating an exception in method2
        throw new Exception("Exception in method2");
    }
}
