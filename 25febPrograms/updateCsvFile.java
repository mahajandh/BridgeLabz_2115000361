import java.io.*;
import java.nio.file.*;

public class UpdateCSVFile {
    public static void main(String[] args) {
        String inputFile = "employees.csv";  // Input CSV file
        String outputFile = "updated_employees.csv"; // Output CSV file
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            // Read and write header
            String header = br.readLine();
            bw.write(header + "\n");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4 && data[2].trim().equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(data[3].trim());
                    salary *= 1.10; // Increase by 10%
                    data[3] = String.format("%.2f", salary);
                }
                bw.write(String.join(",", data) + "\n");
            }

            System.out.println("Updated salaries saved to: " + outputFile);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
