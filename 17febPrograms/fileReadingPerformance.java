import java.io.*;

public class FileReadingPerformance {
    public static void main(String[] args) {
        String filePath = "largefile.txt"; // Replace with actual large file path
        
        System.out.println("Reading file using FileReader...");
        long start = System.nanoTime();
        readUsingFileReader(filePath);
        long fileReaderTime = System.nanoTime() - start;
        System.out.println("FileReader Time: " + fileReaderTime / 1_000_000.0 + " ms\n");
        
        System.out.println("Reading file using InputStreamReader...");
        start = System.nanoTime();
        readUsingInputStreamReader(filePath);
        long inputStreamReaderTime = System.nanoTime() - start;
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime / 1_000_000.0 + " ms");
    }

    public static void readUsingFileReader(String filePath) {
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.read() != -1) {}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readUsingInputStreamReader(String filePath) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            while (bufferedReader.read() != -1) {}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
