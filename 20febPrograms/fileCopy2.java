import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "largefile.txt";
        String destinationFileBuffered = "destination_buffered.txt";
        String destinationFileUnbuffered = "destination_unbuffered.txt";

        // Buffered Streams
        long startBuffered = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile), 4096);
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFileBuffered), 4096)) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("Buffered file copy completed.");
            
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
        long endBuffered = System.nanoTime();
        System.out.println("Buffered copy time: " + (endBuffered - startBuffered) + " ns");
        
        // Unbuffered Streams
        long startUnbuffered = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFileUnbuffered)) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Unbuffered file copy completed.");
            
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
        long endUnbuffered = System.nanoTime();
        System.out.println("Unbuffered copy time: " + (endUnbuffered - startUnbuffered) + " ns");
    }
}
