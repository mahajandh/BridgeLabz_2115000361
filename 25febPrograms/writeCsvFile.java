import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVFile {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Output CSV file

        String[] employees = {
            "101,John,HR,50000",
            "102,Emma,IT,60000",
            "103,Michael,Finance,55000",
            "104,Sophia,Marketing,52000",
            "105,Daniel,Operations,58000"
        };

        try (FileWriter writer = new FileWriter(filePath)) {
            // Writing header
            writer.append("ID,Name,Department,Salary\n");

            // Writing employee records
            for (String emp : employees) {
                writer.append(emp).append("\n");
            }

            System.out.println("CSV file created successfully: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
