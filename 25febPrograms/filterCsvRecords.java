import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCSVRecords {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Update with your CSV file path
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the header line
            String header = br.readLine();
            System.out.println("Students with Marks > 80:");
            System.out.println("--------------------------------");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int marks = Integer.parseInt(data[3].trim());
                    if (marks > 80) {
                        System.out.printf("ID: %s, Name: %s, Age: %s, Marks: %d%n", 
                                          data[0], data[1], data[2], marks);
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
