class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    // Constructor to initialize the student details
    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public method to access CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public method to modify CGPA
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 4.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA value.");
        }
    }

    // Method to display student details
    void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass PostgraduateStudent demonstrating the use of protected members
class PostgraduateStudent extends Student {
    // Constructor to initialize the postgraduate student details
    PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    // Method to display postgraduate student details
    void displayPostgraduateDetails() {
        System.out.println("Postgraduate Student Details:");
        System.out.println("Roll Number: " + rollNumber);  // Accessing public member
        System.out.println("Name: " + name);  // Accessing protected member
        System.out.println("CGPA: " + getCGPA());  // Accessing private member via public method
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Creating a Student instance
        Student student = new Student(101, "John Doe", 3.8);
        student.displayDetails();

        // Modifying CGPA via public methods
        student.setCGPA(3.9);
        System.out.println("\nAfter CGPA Update:");
        student.displayDetails();

        // Creating a PostgraduateStudent instance
        PostgraduateStudent pgStudent = new PostgraduateStudent(102, "Jane Smith", 3.7);
        pgStudent.displayPostgraduateDetails();
    }
}
