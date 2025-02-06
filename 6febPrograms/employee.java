import java.util.ArrayList;

// Employee class
class Employee {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', position='" + position + "'}";
    }
}

// Department class (Composition with Employee)
class Department {
    private String name;
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String employeeName, String position) {
        employees.add(new Employee(employeeName, position));
    }

    public void displayEmployees() {
        System.out.println("Department: " + name);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

// Company class (Composition with Department)
class Company {
    private String name;
    private ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addEmployeeToDepartment(String departmentName, String employeeName, String position) {
        for (Department dept : departments) {
            if (dept.name.equals(departmentName)) {
                dept.addEmployee(employeeName, position);
                return;
            }
        }
        System.out.println("Department not found: " + departmentName);
    }

    public void displayCompany() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.displayEmployees();
        }
    }
}

// Main class to demonstrate composition
public class CompanySystem {
    public static void main(String[] args) {
        // Create company
        Company company = new Company("TechCorp");

        // Add departments
        company.addDepartment("Engineering");
        company.addDepartment("Marketing");

        // Add employees to departments
        company.addEmployeeToDepartment("Engineering", "Alice", "Software Engineer");
        company.addEmployeeToDepartment("Engineering", "Bob", "DevOps Engineer");
        company.addEmployeeToDepartment("Marketing", "Charlie", "Marketing Manager");

        // Display company structure
        company.displayCompany();
    }
}
