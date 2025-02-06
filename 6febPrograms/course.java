
import java.util.ArrayList;

// Course class
class Course {
    private String name;
    private ArrayList<Student> enrolledStudents;

    public Course(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public void displayStudents() {
        System.out.println("Course: " + name + " - Enrolled Students:");
        for (Student student : enrolledStudents) {
            System.out.println(student.getName());
        }
    }
}

// Student class
class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudent(this);
        }
    }

    public void displayCourses() {
        System.out.println("Student: " + name + " - Enrolled Courses:");
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }
}

// School class (Aggregation with Student)
class School {
    private String name;
    private ArrayList<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void displayStudents() {
        System.out.println("School: " + name + " - Students:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}

// Main class to demonstrate association and aggregation
public class SchoolSystem {
    public static void main(String[] args) {
        // Create school
        School school = new School("Greenwood High");

        // Create students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Create courses
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Science");

        // Enroll students in courses
        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course1);

        // Add students to school
        school.addStudent(student1);
        school.addStudent(student2);

        // Display details
        school.displayStudents();
        student1.displayCourses();
        student2.displayCourses();
        course1.displayStudents();
        course2.displayStudents();
    }
}

