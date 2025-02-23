import java.lang.reflect.Method;

// Step 1: Define a sample class with methods to measure execution time
class SampleClass {
    public void fastMethod() {
        System.out.println("Fast method executed.");
    }
    
    public void slowMethod() {
        try {
            Thread.sleep(1000); // Simulate a slow method
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Slow method executed.");
    }
}

// Step 2: Implement a method to measure execution time using Reflection
public class MethodExecutionTimer {
    public static void measureExecutionTime(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            long startTime = System.nanoTime();
            method.invoke(obj);
            long endTime = System.nanoTime();
            
            System.out.println("Execution time for " + methodName + ": " + (endTime - startTime) / 1_000_000.0 + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Step 3: Test the method execution timing
    public static void main(String[] args) {
        SampleClass sample = new SampleClass();
        measureExecutionTime(sample, "fastMethod");
        measureExecutionTime(sample, "slowMethod");
    }
}
