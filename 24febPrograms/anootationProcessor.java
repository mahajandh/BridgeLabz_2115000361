import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

// Step 2: Apply annotation to a method in TaskManager class
class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void completeTask() {
        System.out.println("Task completed!");
    }
}

// Step 3: Retrieve annotation details using Reflection API
public class AnnotationProcessor {
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("completeTask");
        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }
    }
}
