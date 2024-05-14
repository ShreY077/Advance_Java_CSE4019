import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ReadFromFile {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file name to read: ");
        String fileName = scanner.nextLine();

        
        Path filePath = Path.of(fileName);

        
        try {
            
            if (Files.exists(filePath)) {
                
                System.out.println("Data read from the file:");
                Files.readAllLines(filePath).forEach(System.out::println);
            } else {
                System.out.println("The specified file does not exist.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        } finally {
            
            scanner.close();
        }
    }
}
