import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the @LogExecutionTime annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

// Step 2: Apply annotation to methods
class PerformanceTest {
    @LogExecutionTime
    public void processData() {
        try {
            Thread.sleep(500); // Simulating processing time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void quickTask() {
        try {
            Thread.sleep(200); // Simulating quicker processing time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Step 3: Measure and log execution time using Reflection
public class ExecutionTimeLogger {
    public static void main(String[] args) throws Exception {
        PerformanceTest test = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(test);
                long endTime = System.nanoTime();
                System.out.println("Method: " + method.getName() + " | Execution Time: " + (endTime - startTime) / 1_000_000 + " ms");
            }
        }
    }
}
