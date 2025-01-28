import java.util.Scanner;

public class EuclideanDistanceAndLineEquation {

    // Method to calculate the Euclidean distance between two points
    public static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
        // Applying the formula for Euclidean distance
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    // Method to find the equation of the line given two points
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double[] result = new double[2];  // To store slope and y-intercept
        
        // Calculate the slope m
        double m = (y2 - y1) / (x2 - x1);
        
        // Calculate the y-intercept b
        double b = y1 - m * x1;
        
        // Store the slope and y-intercept in the array
        result[0] = m;  // slope
        result[1] = b;  // y-intercept
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking inputs for the two points
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();

        // Calculate the Euclidean distance
        double distance = calculateEuclideanDistance(x1, y1, x2, y2);
        System.out.println("Euclidean Distance between the points: " + distance);

        // Find the line equation
        double[] equation = findLineEquation(x1, y1, x2, y2);
        double slope = equation[0];
        double intercept = equation[1];

        // Display the equation of the line
        System.out.println("Equation of the line: y = " + slope + "x + " + intercept);
    }
}
