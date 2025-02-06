
import java.util.ArrayList;

// Faculty class (Aggregation - Faculty can exist independently)
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Department class (Composition - Exists only within University)
class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// University class (Composition with Department, Aggregation with Faculty)
class University {
    private String name;
    private ArrayList<Department> departments;
    private ArrayList<Faculty> faculties;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void displayDetails() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department dept : departments) {
            System.out.println("- " + dept.getName());
        }
        System.out.println("Faculty Members:");
        for (Faculty faculty : faculties) {
            System.out.println("- " + faculty.getName());
        }
    }
}

// Main class to demonstrate composition and aggregation
public class UniversitySystem {
    public static void main(String[] args) {
        // Create university
        University university = new University("Tech University");

        // Add departments (Composition - tied to university)
        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");

        // Create faculty members (Aggregation - independent existence)
        Faculty faculty1 = new Faculty("Dr. Smith");
        Faculty faculty2 = new Faculty("Dr. Johnson");

        // Add faculty to university
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        // Display university details
        university.displayDetails();
    }
}

