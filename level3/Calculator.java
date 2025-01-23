
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double first = scanner.nextDouble();
        
        System.out.print("Enter second number: ");
        double second = scanner.nextDouble();
        
        System.out.print("Enter operator (+, -, *, /): ");
        String op = scanner.next();
        
        double result = 0;
        boolean valid = true;
        
        switch (op) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                if (second != 0) {
                    result = first / second;
                } else {
                    System.out.println("Error: Division by zero.");
                    valid = false;
                }
                break;
            default:
                System.out.println("Invalid Operator");
                valid = false;
        }
        
        if (valid) {
            System.out.println("Result: " + result);
        }
        
        scanner.close();
    }
}

