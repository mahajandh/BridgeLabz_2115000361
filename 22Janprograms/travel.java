import java.util.Scanner;
public class TravelDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input details for name, cities, and distances
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter the starting city: ");
        String fromCity = scanner.nextLine();
        
        System.out.print("Enter the via city: ");
        String viaCity = scanner.nextLine();
        
        System.out.print("Enter the final destination city: ");
        String toCity = scanner.nextLine();
        
        System.out.print("Enter distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToVia = scanner.nextDouble();
        
        System.out.print("Enter distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCity = scanner.nextDouble();

        // Input time taken for the journey
        System.out.print("Enter time taken for the journey in hours: ");
        double timeTaken = scanner.nextDouble();
