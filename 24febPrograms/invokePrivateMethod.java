import java.lang.reflect.Method;

// Step 1: Define the Calculator class with a private method
class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

// Step 2: Use Reflection to invoke the private method
public class InvokePrivateMethod {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        
        // Access the private method "multiply"
        Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        multiplyMethod.setAccessible(true);
        
        // Invoke the private method and print the result
        int result = (int) multiplyMethod.invoke(calculator, 5, 10);
        System.out.println("Multiplication Result: " + result);
    }
}
