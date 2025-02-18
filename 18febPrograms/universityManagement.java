import java.util.ArrayList;
import java.util.List;

// Abstract CourseType class
abstract class CourseType {
    private String courseName;
    private String instructor;

    public CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - Course: " + courseName + ", Instructor: " + instructor;
    }
}

// Concrete Course Types
class ExamCourse extends CourseType {
    public ExamCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }
}

// Generic Course class
class Course<T extends CourseType> {
    private List<T> courseList = new ArrayList<>();

    public void addCourse(T course) {
        courseList.add(course);
    }

    public List<T> getCourses() {
        return courseList;
    }
}

// Utility class with wildcard method
class CourseManager {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course);
        }
    }
}

// Main Class
public class UniversityManagement {
    public static void main(String[] args) {
        // Create course lists
        Course<ExamCourse> examCourses = new Course<>();
        Course<AssignmentCourse> assignmentCourses = new Course<>();
        Course<ResearchCourse> researchCourses = new Course<>();

        // Add courses
        examCourses.addCourse(new ExamCourse("Data Structures", "Dr. Smith"));
        examCourses.addCourse(new ExamCourse("Algorithms", "Dr. Johnson"));

        assignmentCourses.addCourse(new AssignmentCourse("Software Engineering", "Prof. Davis"));
        assignmentCourses.addCourse(new AssignmentCourse("Web Development", "Prof. Lee"));

        researchCourses.addCourse(new ResearchCourse("AI Research", "Dr. Brown"));
        researchCourses.addCourse(new ResearchCourse("Quantum Computing", "Dr. Wilson"));

        // Display courses using wildcard method
        System.out.println("Exam Courses:");
        CourseManager.displayCourses(examCourses.getCourses());

        System.out.println("\nAssignment Courses:");
        CourseManager.displayCourses(assignmentCourses.getCourses());

        System.out.println("\nResearch Courses:");
        CourseManager.displayCourses(researchCourses.getCourses());
    }
}
