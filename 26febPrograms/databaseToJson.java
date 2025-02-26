import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private int age;
    private String department;

    public Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
}

public class DatabaseToJson {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name, age, department FROM employees");

            List<Employee> employeeList = new ArrayList<>();
            while (rs.next()) {
                employeeList.add(new Employee(rs.getString("name"), rs.getInt("age"), rs.getString("department")));
            }

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(employeeList);
            
            System.out.println(json);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
