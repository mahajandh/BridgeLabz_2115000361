import java.lang.annotation.*;
import java.lang.reflect.*;

// Step 1: Define the @Author annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

// Step 2: Apply the annotation to a class
@Author(name = "John Doe")
class SampleClass {
    public void display() {
        System.out.println("SampleClass method executed");
    }
}

// Step 3: Retrieve and display annotation value using Reflection
public class RetrieveRuntimeAnnotations {
    public static void main(String[] args) {
        Class<SampleClass> obj = SampleClass.class;
        
        // Check if the annotation is present
        if (obj.isAnnotationPresent(Author.class)) {
            // Retrieve the annotation
            Author author = obj.getAnnotation(Author.class);
            System.out.println("Author Name: " + author.name());
        } else {
            System.out.println("No @Author annotation present.");
        }
    }
}
