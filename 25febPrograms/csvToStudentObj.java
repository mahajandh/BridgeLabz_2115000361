import java.io.*;
import java.util.*;

class Student {
    private String id;
    private String name;
    private int age;
    private int marks;

    public Student(String id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Age: %d, Marks: %d", id, name, age, marks);
    }
}

public class CSVToStudentObjects {
    public static void main(String[] args) {
        String filePath = "students.csv";
        List<Student> students = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    students.add(new Student(data[0], data[1], Integer.parseInt(data[2].trim()), Integer.parseInt(data[3].trim())));
                }
            }

            System.out.println("Student Records:");
            System.out.println("--------------------------");
            students.forEach(System.out::println);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
