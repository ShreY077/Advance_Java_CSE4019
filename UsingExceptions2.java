public class UsingExceptions2 {

    public static void main(String[] args) {
        try {
            // Method call that may cause an exception
            int result = divideByZero();
            System.out.println("Result after division: " + result);
        } catch (ArithmeticException e) {
            // Catching the exception and printing the stack trace
            System.out.println("Error: Cannot divide by zero. Printing Stack Trace:");
            e.printStackTrace();
        }
    }

    public static int divideByZero() {
        // Attempting to divide by zero
        return 10 / 0;
    }
}
