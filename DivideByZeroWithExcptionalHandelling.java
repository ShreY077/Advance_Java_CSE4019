import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZeroWithExcptionalHandelling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("Enter first number (numerator) : ");
            try {
                int num1 = scanner.nextInt();
                System.out.println("Enter second number (denominator) : ");
                int num2 = scanner.nextInt();
                int result = num1 / num2;
                System.out.println("Result = " + result);
            } catch (InputMismatchException e) {
                System.out.println("Error: Input mismatch, Please enter valid integers");
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Do you want to quit? (y/n) ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("y")) {
                    quit = true;
                }
            }
        }

        scanner.close();
    }
}