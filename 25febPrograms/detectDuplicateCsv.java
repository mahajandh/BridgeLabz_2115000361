import java.io.*;
import java.util.*;

public class DetectDuplicateCSV {
    public static void main(String[] args) {
        String filePath = "data.csv";
        Map<String, String> recordMap = new HashMap<>();
        Set<String> duplicates = new HashSet<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0) {
                    String id = data[0].trim();
                    if (recordMap.containsKey(id)) {
                        duplicates.add(line);
                    } else {
                        recordMap.put(id, line);
                    }
                }
            }

            if (!duplicates.isEmpty()) {
                System.out.println("Duplicate Records:");
                duplicates.forEach(System.out::println);
            } else {
                System.out.println("No duplicate records found.");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
