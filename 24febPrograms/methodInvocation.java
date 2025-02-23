import java.lang.reflect.Method;
import java.util.Scanner;

// Step 1: Define the MathOperations class with multiple methods
class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
}

// Step 2: Use Reflection to invoke methods dynamically based on user input
public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();
        
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        
        // Get the MathOperations class and method
        MathOperations operations = new MathOperations();
        Method method = MathOperations.class.getMethod(methodName, int.class, int.class);
        
        // Invoke the method dynamically
        int result = (int) method.invoke(operations, num1, num2);
        System.out.println("Result: " + result);
        
        scanner.close();
    }
}
