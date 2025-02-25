import java.io.*;
import java.util.*;

public class SortCSVRecords {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // CSV file path
        List<String[]> records = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the header
            String header = br.readLine();

            // Read and store records
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    records.add(data);
                }
            }

            // Sort records by salary in descending order
            records.sort((a, b) -> Double.compare(Double.parseDouble(b[3].trim()), Double.parseDouble(a[3].trim())));

            // Print top 5 highest-paid employees
            System.out.println("Top 5 Highest-Paid Employees:");
            System.out.println("--------------------------------");
            int count = Math.min(5, records.size());
            for (int i = 0; i < count; i++) {
                System.out.printf("ID: %s, Name: %s, Department: %s, Salary: %s%n",
                                  records.get(i)[0], records.get(i)[1], records.get(i)[2], records.get(i)[3]);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
