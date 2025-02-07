class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayRole() {
        // This can be overridden by subclasses
    }
}

// Subclass Teacher
class Teacher extends Person {
    String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void displayRole() {
        System.out.println(name + " is a teacher, teaching " + subject + ".");
    }
}

// Subclass Student
class Student extends Person {
    int grade;

    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    public void displayRole() {
        System.out.println(name + " is a student in grade " + grade + ".");
    }
}

// Subclass Staff
class Staff extends Person {
    String position;

    public Staff(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }

    @Override
    public void displayRole() {
        System.out.println(name + " is a staff member working as " + position + ".");
    }
}

// Main class to demonstrate the system
public class SchoolSystem {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Smith", 40, "Math");
        Student student = new Student("Alice", 15, 10);
        Staff staff = new Staff("Mrs. Johnson", 50, "Janitor");

        teacher.displayRole();
        student.displayRole();
        staff.displayRole();
    }
}

