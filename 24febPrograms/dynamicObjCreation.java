import java.lang.reflect.Constructor;

// Step 1: Define the Student class
class Student {
    private String name;
    private int age;
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void display() {
        System.out.println("Student Name: " + name + ", Age: " + age);
    }
}

// Step 2: Create an instance dynamically using Reflection
public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        // Get the constructor of the Student class
        Constructor<Student> constructor = Student.class.getConstructor(String.class, int.class);
        
        // Create an instance without using "new" keyword
        Student student = constructor.newInstance("Alice", 22);
        
        // Call a method on the dynamically created object
        student.display();
    }
}
