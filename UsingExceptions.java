public class UsingExceptions {

    public static void main(String[] args) {
        try {
            // Code that might cause an exception
            int result = divideByZero();
            System.out.println("Result after division: " + result);
        } catch (ArithmeticException e) {
            // Handling specific exception (ArithmeticException in this case)
            System.out.println("Error: Cannot divide by zero.");
        } finally {
            // Code that will be executed regardless of whether an exception occurred or not
            System.out.println("Finally Executed ...");
        }
    }

    public static int divideByZero() {
        // Attempting to divide by zero
        return 10 / 0;
    }
}
