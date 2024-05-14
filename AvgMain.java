import java.util.Scanner;

public class AvgMain {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the numbers separated by space: ");
            String[] inputs = scanner.nextLine().split(" ");
            int[] numbers = new int[inputs.length];
            for (int i = 0; i < inputs.length; i++) {
                numbers[i] = Integer.parseInt(inputs[i]);
            }
            System.out.println("The average is: " + average(numbers));
        }
    }

    public static double average(int... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("No numbers provided.");
        }
        long sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.length;
    }
}