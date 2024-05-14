import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        System.out.print("Enter the data to write to the file: ");
        String data = scanner.nextLine();

        
        Path filePath = Path.of(fileName);

        
        try {
            Files.write(filePath, data.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            System.out.println("Data has been written to the file successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        } finally {
            
            scanner.close();
        }
    }
}
