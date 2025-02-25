import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Update with your CSV file path
        int rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the header line
            br.readLine();

            // Count the records
            while (br.readLine() != null) {
                rowCount++;
            }

            System.out.println("Total records (excluding header): " + rowCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
