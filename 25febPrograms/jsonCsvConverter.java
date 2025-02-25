import java.io.*;
import java.util.*;
import org.json.*;

public class JSONCSVConverter {
    
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);
            }

            JSONArray students = new JSONArray(jsonContent.toString());
            bw.write("ID,Name,Age,Marks\n");

            for (int i = 0; i < students.length(); i++) {
                JSONObject student = students.getJSONObject(i);
                bw.write(student.getInt("id") + "," +
                         student.getString("name") + "," +
                         student.getInt("age") + "," +
                         student.getInt("marks") + "\n");
            }
            System.out.println("Converted JSON to CSV: " + csvFile);
        } catch (IOException | JSONException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void csvToJson(String csvFile, String jsonFile) {
        JSONArray students = new JSONArray();
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile))) {
            
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                JSONObject student = new JSONObject();
                student.put("id", Integer.parseInt(data[0].trim()));
                student.put("name", data[1].trim());
                student.put("age", Integer.parseInt(data[2].trim()));
                student.put("marks", Integer.parseInt(data[3].trim()));
                students.put(student);
            }

            bw.write(students.toString(4));
            System.out.println("Converted CSV to JSON: " + jsonFile);
        } catch (IOException | JSONException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        jsonToCsv("students.json", "students.csv");
        csvToJson("students.csv", "students_converted.json");
    }
}
