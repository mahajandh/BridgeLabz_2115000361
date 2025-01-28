
import java.util.Scanner;

public class Quadratic {

    // Method to find the roots of the quadratic equation ax^2 + bx + c = 0
    public static double[] findRoots(double a, double b, double c) {
        // Calculate the discriminant (delta)
        double delta = Math.pow(b, 2) - 4 * a * c;
        
        if (delta > 0) {
            // Two real roots
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[] {root1, root2};
        } else if (delta == 0) {
            // One real root
            double root = -b / (2 * a);
            return new double[] {root};
        } else {
            // No real roots
            return new double[0];
        }
    }

    public static void main(String[] args) {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Taking input for the coefficients a, b, and c
        System.out.print("Enter the coefficient a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter the coefficient b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Enter the coefficient c: ");
        double c = scanner.nextDouble();
        
        // Find the roots using the findRoots method
        double[] roots = findRoots(a, b, c);
        
        // Display the results
        if (roots.length == 0) {
            System.out.println("No real roots.");
        } else if (roots.length == 1) {
            System.out.println("One real root: " + roots[0]);
        } else {
            System.out.println("Two real roots: " + roots[0] + " and " + roots[1]);
        }

        // Close scanner
        scanner.close();
    }
}

