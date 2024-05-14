import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ColorMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> colors = new ArrayList<>();

        while (true) {
            System.out.println("Enter your choice: ");
            System.out.println("1. Add a color");
            System.out.println("2. Remove a color");
            System.out.println("3. Print all colors");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline not consumed by nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Enter a color to add: ");
                    String colorToAdd = scanner.nextLine();
                    colors.add(colorToAdd);
                    break;
                case 2:
                    System.out.print("Enter a color to remove: ");
                    String colorToRemove = scanner.nextLine();
                    colors.remove(colorToRemove);
                    break;
                case 3:
                    System.out.println("All colors: " + colors);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close(); // close the scanner
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}