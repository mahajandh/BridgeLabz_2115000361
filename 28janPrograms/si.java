import java.util.Scanner;

public class SimpleInterestCalculator {
    // Method to calculate Simple Interest
    static double calculateInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter Principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rate = scanner.nextDouble();

        System.out.print("Enter Time (in years): ");
        double time = scanner.nextDouble();

        // Calculate simple interest
        double interest = calculateInterest(principal, rate, time);

        // Output the result
        System.out.println("The Simple Interest is " + interest + 
                           " for Principal " + principal + 
                           ", Rate of Interest " + rate + 
                           " and Time " + time);

        scanner.close();
    }
}