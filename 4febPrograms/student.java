
class Student {
    private static String universityName = "Global University";
    private static int totalStudents = 0;
    private final int rollNumber;
    private String name;
    private char grade;

    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Name: " + this.name);
            System.out.println("Roll Number: " + this.rollNumber);
            System.out.println("Grade: " + this.grade);
        } else {
            System.out.println("Invalid student instance.");
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Alice Brown", 101, 'A');
        Student student2 = new Student("Bob White", 102, 'B');

        displayTotalStudents();
        student1.displayStudentDetails();
        student2.displayStudentDetails();
    }
}

