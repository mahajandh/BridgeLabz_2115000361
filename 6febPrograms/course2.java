
import java.util.ArrayList;

// Course class
class Course {
    private String name;
    private Professor professor;
    private ArrayList<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.enrollCourse(this);
        }
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + name);
        if (professor != null) {
            System.out.println("Taught by: " + professor.getName());
        }
        System.out.println("Enrolled Students:");
        for (Student student : students) {
            System.out.println("- " + student.getName());
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

    public void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void displayCourses() {
        System.out.println("Student: " + name + " - Enrolled Courses:");
        for (Course course : courses) {
            System.out.println("- " + course.getName());
        }
    }
}

// Professor class
class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// University Management System
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Create professors
        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");

        // Create courses
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Computer Science");

        // Assign professors to courses
        course1.assignProfessor(professor1);
        course2.assignProfessor(professor2);

        // Enroll students in courses
        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        course2.enrollStudent(student1);

        // Display course information
        course1.displayCourseInfo();
        course2.displayCourseInfo();

        // Display student course enrollments
        student1.displayCourses();
        student2.displayCourses();
    }
}

