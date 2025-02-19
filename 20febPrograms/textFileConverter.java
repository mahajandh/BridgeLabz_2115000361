import java.io.*;

public class TextFileConverter {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        convertUppercaseToLowercase(sourceFile, destinationFile);
    }

    private static void convertUppercaseToLowercase(String source, String destination) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(source), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destination), "UTF-8"))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File conversion completed successfully.");
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
