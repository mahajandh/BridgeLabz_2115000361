class Employee {
    public int employeeID;  // Public variable
    protected String department;  // Protected variable
    private double salary;  // Private variable

    // Constructor to initialize employee details
    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to get the salary
    public double getSalary() {
        return salary;
    }

    // Public method to modify the salary
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary amount.");
        }
    }

    // Method to display employee details
    void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

// Subclass Manager demonstrating the use of access modifiers
class Manager extends Employee {

    // Constructor to initialize manager details
    Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    // Method to display manager details (accessing protected and public members)
    void displayManagerDetails() {
        System.out.println("Manager Details:");
        System.out.println("Employee ID: " + employeeID);  // Accessing public variable
        System.out.println("Department: " + department);  // Accessing protected variable
        System.out.println("Salary: $" + getSalary());  // Accessing private member via public method
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        // Creating an Employee instance
        Employee employee = new Employee(101, "IT", 50000.00);
        employee.displayEmployeeDetails();

        // Modifying the salary using the setter method
        employee.setSalary(55000.00);
        System.out.println("\nAfter Salary Update:");
        employee.displayEmployeeDetails();

        // Creating a Manager instance
        Manager manager = new Manager(102, "HR", 70000.00);
        manager.displayManagerDetails();
    }
}
