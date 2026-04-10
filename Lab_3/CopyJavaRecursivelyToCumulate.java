import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class CopyJavaRecursivelyToCumulate {
    public static void main(String[] args) {
        // Current working directory
        Path currentDir = Paths.get(System.getProperty("user.dir"));
        Path cumulateDir = currentDir.resolve("Cumulate");

        // Create Cumulate directory if it doesn't exist
        try {
            if (!Files.exists(cumulateDir)) {
                Files.createDirectory(cumulateDir);
                System.out.println("Created directory: " + cumulateDir);
            }
        } catch (IOException e) {
            System.out.println("Failed to create Cumulate directory: " + e.getMessage());
            return;
        }

        // Recursively find all .java files and copy to Cumulate
        try (Stream<Path> stream = Files.walk(currentDir)) {
            stream.filter(f -> Files.isRegularFile(f) && f.toString().endsWith(".java"))
                  .forEach(f -> {
                      Path destination = cumulateDir.resolve(f.getFileName());
                      try {
                          Files.copy(f, destination, StandardCopyOption.REPLACE_EXISTING);
                          System.out.println("Copied: " + f + " to " + destination);
                      } catch (IOException e) {
                          System.out.println("Failed to copy " + f + ": " + e.getMessage());
                      }
                  });
        } catch (IOException e) {
            System.out.println("Error searching for .java files: " + e.getMessage());
        }
    }
}