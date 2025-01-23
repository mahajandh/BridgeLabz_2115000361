import java.util.Scanner;
public class BonusCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter salary and years of service
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Enter years of service: ");
        int yearsOfService = scanner.nextInt();

        // Check if the employee is eligible for the bonus
        if (yearsOfService > 5) {
            // Calculate the bonus (5% of salary)
            double bonus = salary * 0.05;
            System.out.println("The bonus is: " + bonus);
        } else {
            System.out.println("No bonus for employees with 5 or less years of service.");
        }

        // Close the scanner
        scanner.close();
    }
}
