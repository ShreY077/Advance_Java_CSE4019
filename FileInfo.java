import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class FileInfo {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path of the file or directory: ");
        String filePath = scanner.nextLine();

        
        Path path = FileSystems.getDefault().getPath(filePath);

        
        if (Files.exists(path)) {
            
            System.out.println("File/Directory Information:");

            
            System.out.println("Name: " + path.getFileName());

            
            System.out.println("Absolute Path: " + path.toAbsolutePath());

            
            if (Files.isRegularFile(path)) {
                try {
                    long fileSize = Files.size(path);
                    System.out.println("Size: " + fileSize + " bytes");
                } catch (Exception e) {
                    System.out.println("Unable to retrieve file size.");
                }
            }

            
            try {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.println("Creation Time: " + attributes.creationTime());
                System.out.println("Last Modified Time: " + attributes.lastModifiedTime());
            } catch (Exception e) {
                System.out.println("Unable to retrieve file attributes.");
            }

            
            if (Files.isDirectory(path)) {
                System.out.println("Type: Directory");
            } else if (Files.isRegularFile(path)) {
                System.out.println("Type: File");
            } else {
                System.out.println("Type: Other");
            }
        } else {
            System.out.println("The specified file or directory does not exist.");
        }

        
        scanner.close();
    }
}
