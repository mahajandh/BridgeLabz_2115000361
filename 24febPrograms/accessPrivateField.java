import java.lang.reflect.Field;

// Step 1: Define the Person class with a private field
class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Step 2: Use Reflection to access and modify the private field
public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person person = new Person("John", 30);
        
        // Access the private field "age"
        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);
        
        // Get and print original value
        System.out.println("Original Age: " + ageField.get(person));
        
        // Modify the private field
        ageField.set(person, 35);
        
        // Get and print modified value
        System.out.println("Modified Age: " + ageField.get(person));
    }
}
