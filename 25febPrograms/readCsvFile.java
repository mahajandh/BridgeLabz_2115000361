import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Update with your CSV file path
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the header line (optional)
            br.readLine();

            System.out.println("Student Details:");
            System.out.println("-------------------------------");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    System.out.printf("ID: %s, Name: %s, Age: %s, Marks: %s%n", 
                                      data[0], data[1], data[2], data[3]);
                } else {
                    System.out.println("Invalid record: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
