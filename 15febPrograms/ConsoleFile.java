import java.io.*;

public class ConsoleToFile {
    public static void main(String[] args) {
        String filePath = "output.txt"; // Change to your desired file path

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) { // Append mode

            System.out.println("Enter text (type 'exit' to stop):");

            String line;
            while ((line = reader.readLine()) != null) {
                if ("exit".equalsIgnoreCase(line)) {
                    break;
                }
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Input saved to " + filePath);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
