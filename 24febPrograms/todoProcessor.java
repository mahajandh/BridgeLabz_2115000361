import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the @Todo annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

// Step 2: Apply annotation to multiple methods
class Project {
    @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
    public void authenticationFeature() {
        System.out.println("Authentication feature in progress");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Database optimization in progress");
    }

    @Todo(task = "Enhance UI components", assignedTo = "Charlie", priority = "LOW")
    public void enhanceUI() {
        System.out.println("UI enhancement in progress");
    }
}

// Step 3: Retrieve and print all pending tasks using Reflection
public class TodoProcessor {
    public static void main(String[] args) {
        Method[] methods = Project.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("------------------------");
            }
        }
    }
}
