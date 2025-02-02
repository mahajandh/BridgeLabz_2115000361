
class Course {
    String courseName;
    int duration; // Duration in weeks
    double fee;
    static String instituteName = "Global Academy"; // Class variable

    // Constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: $" + fee);
    }

    // Class method to update the institute name
    static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        // Creating course instances
        Course c1 = new Course("Java Programming", 8, 499.99);
        Course c2 = new Course("Data Science", 12, 799.99);

        // Displaying course details
        c1.displayCourseDetails();
        System.out.println(); // Line break
        c2.displayCourseDetails();
        System.out.println(); // Line break

        // Updating institute name
        Course.updateInstituteName("Tech Academy");

        // Displaying course details after update
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}

