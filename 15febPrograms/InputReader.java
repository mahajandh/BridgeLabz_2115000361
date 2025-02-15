import java.io.*;

public class InputStreamReaderExample {
    public static void readFileWithEncoding(String filePath, String charset) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), charset))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "example.txt"; // Change to your file path
        String charset = "UTF-8"; // Specify encoding

        readFileWithEncoding(filePath, charset);
    }
}
