import java.io.*;
import java.sql.*;

public class GenerateCSVFromDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "password";
        String query = "SELECT id, name, department, salary FROM employees";
        String csvFile = "employees_report.csv";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {

            bw.write("Employee ID,Name,Department,Salary\n");

            while (rs.next()) {
                bw.write(rs.getInt("id") + "," +
                         rs.getString("name") + "," +
                         rs.getString("department") + "," +
                         rs.getDouble("salary") + "\n");
            }

            System.out.println("CSV report generated: " + csvFile);
        } catch (SQLException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
