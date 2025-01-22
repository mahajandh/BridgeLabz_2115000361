import java.util.Scanner;

public class DoubleOpt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		       System.out.print("Enter value for a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter value for b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter value for c: ");
        double c = scanner.nextDouble();

        // Calculate double operations
        double result1 = a + b * c;   // Multiplication first due to precedence
        double result2 = a * b + c;   // Multiplication first, then addition
        double result3 = c + a / b;   // Division first, then addition
        double result4 = a % b + c;   // Modulus first, then addition

        // Output the results
        System.out.println("The results of Double Operations are " + result1 + ", " + result2 + ", and " + result3 + ", " + result4);
    }
}