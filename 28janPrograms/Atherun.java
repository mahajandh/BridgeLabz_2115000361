import java.util.Scanner;

public class AthleteRunCalculator {
    
    // Method to compute the number of rounds
    static double calculateRounds(double side1, double side2, double side3, double totalDistance) {
        // Calculate the perimeter of the triangle
        double perimeter = side1 + side2 + side3;
        
        // Calculate the number of rounds (totalDistance / perimeter)
        return totalDistance / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking user input for the sides of the triangle
        System.out.print("Enter the first side of the triangle (in meters): ");
        double side1 = scanner.nextDouble();
        
        System.out.print("Enter the second side of the triangle (in meters): ");
        double side2 = scanner.nextDouble();
        
        System.out.print("Enter the third side of the triangle (in meters): ");
        double side3 = scanner.nextDouble();
        
        // The total distance to run is 5 km (5000 meters)
        double totalDistance = 5000;

        // Calculate the number of rounds
        double rounds = calculateRounds(side1, side2, side3, totalDistance);
        
        // Display the result
        System.out.println("The athlete needs to complete " + rounds + " rounds to run 5 km.");
        
        scanner.close();
    }
}