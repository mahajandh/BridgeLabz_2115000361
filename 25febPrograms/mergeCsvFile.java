import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";
        Map<String, String[]> studentMap = new HashMap<>();
        String line;

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            br1.readLine();
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    studentMap.put(data[0], new String[]{data[1], data[2]});
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file1: " + e.getMessage());
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader(file2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            br2.readLine();
            bw.write("ID,Name,Age,Marks,Grade\n");

            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3 && studentMap.containsKey(data[0])) {
                    String[] studentInfo = studentMap.get(data[0]);
                    bw.write(String.join(",", data[0], studentInfo[0], studentInfo[1], data[1], data[2]) + "\n");
                }
            }
            System.out.println("Merged CSV created: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error processing file2: " + e.getMessage());
        }
    }
}
