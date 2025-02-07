class Employee {
    String name;
    int id;
    double salary;

    // Constructor
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: $" + salary);
    }
}

// Subclass: Manager
class Manager extends Employee {
    int teamSize;

    // Constructor
    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    // Overriding displayDetails method
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

// Subclass: Developer
class Developer extends Employee {
    String programmingLanguage;

    // Constructor
    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    // Overriding displayDetails method
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Subclass: Intern
class Intern extends Employee {
    String collegeName;

    // Constructor
    Intern(String name, int id, double salary, String collegeName) {
        super(name, id, salary);
        this.collegeName = collegeName;
    }

    // Overriding displayDetails method
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("College Name: " + collegeName);
    }
}

// Main Class to test Employee Management System
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Creating objects of each employee type
        Employee manager = new Manager("Alice", 101, 90000, 5);
        Employee developer = new Developer("Bob", 102, 80000, "Java");
        Employee intern = new Intern("Charlie", 103, 30000, "XYZ University");

        // Displaying details of each employee
        System.out.println("Manager Details:");
        manager.displayDetails();
        System.out.println();

        System.out.println("Developer Details:");
        developer.displayDetails();
        System.out.println();

        System.out.println("Intern Details:");
        intern.displayDetails();
    }
}
