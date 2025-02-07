class Course {
    String courseName;
    int duration;  // Duration in hours

    // Constructor
    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Method to display course details
    void displayInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

// Subclass: OnlineCourse
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    // Constructor
    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);  // Calling Course constructor
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    // Overriding displayInfo method to include online course details
    @Override
    void displayInfo() {
        super.displayInfo();  // Display basic course info
        System.out.println("Platform: " + platform);
        System.out.println("Is Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass: PaidOnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    // Constructor
    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);  // Calling OnlineCourse constructor
        this.fee = fee;
        this.discount = discount;
    }

    // Overriding displayInfo method to include paid course details
    @Override
    void displayInfo() {
        super.displayInfo();  // Display online course info
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
    }
}

// Main Class to test Educational Course Hierarchy
public class CourseManagementSystem {
    public static void main(String[] args) {
        // Creating objects for different course types
        Course course = new Course("Java Programming", 40);
        OnlineCourse onlineCourse = new OnlineCourse("Python Programming", 30, "Udemy", true);
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Web Development", 50, "Coursera", true, 200.0, 15.0);

        // Displaying details of each course type
        System.out.println("Basic Course Details:");
        course.displayInfo();
        System.out.println();

        System.out.println("Online Course Details:");
        onlineCourse.displayInfo();
        System.out.println();

        System.out.println("Paid Online Course Details:");
        paidCourse.displayInfo();
    }
}
