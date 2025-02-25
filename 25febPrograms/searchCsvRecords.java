import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchCSVRecord {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Update with your CSV file path
        String line;
        boolean found = false;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();
        scanner.close();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4 && data[1].trim().equalsIgnoreCase(searchName)) {
                    System.out.printf("Employee Found: Department: %s, Salary: %s%n", data[2], data[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
