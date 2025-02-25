import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String line;
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^\\d{10}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            System.out.println("Invalid Records:");
            System.out.println("---------------------------");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    Matcher emailMatcher = emailPattern.matcher(data[3].trim());
                    Matcher phoneMatcher = phonePattern.matcher(data[4].trim());

                    if (!emailMatcher.matches()) {
                        System.out.printf("Invalid Email: %s in record: %s%n", data[3], line);
                    }
                    if (!phoneMatcher.matches()) {
                        System.out.printf("Invalid Phone: %s in record: %s%n", data[4], line);
                    }
                } else {
                    System.out.println("Malformed record: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
