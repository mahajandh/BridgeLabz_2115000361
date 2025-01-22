import java.util.Scanner;

public class AthleteRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the sides of the triangle in meters
        System.out.print("Enter the length of side 1 in meters: ");
        double side1 = scanner.nextDouble();
        
        System.out.print("Enter the length of side 2 in meters: ");
        double side2 = scanner.nextDouble();
        
        System.out.print("Enter the length of side 3 in meters: ");
        double side3 = scanner.nextDouble();

        // Calculate the perimeter of the triangle
        double perimeter = side1 + side2 + side3;

        // Convert the total distance to run (5 km) to meters
        double totalDistanceInMeters = 5000; // 5 km = 5000 meters

        // Calculate the number of rounds
        double rounds = totalDistanceInMeters / perimeter;

        // Output the result
        System.out.println("The total number of rounds the athlete will run to complete 5 km is " + rounds);
    }
}