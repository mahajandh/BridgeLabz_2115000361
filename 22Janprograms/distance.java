import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Take distance in feet as input
        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = input.nextDouble();
		     // Convert feet to yards (1 yard = 3 feet)
        double distanceInYards = distanceInFeet / 3;
        
        // Convert feet to miles (1 mile = 1760 yards)
        double distanceInMiles = distanceInYards / 1760;
        
        // Output the results
        System.out.println("The distance in yards is " + distanceInYards + " and in miles is " + distanceInMiles);
        
        input.close();
    }
}

