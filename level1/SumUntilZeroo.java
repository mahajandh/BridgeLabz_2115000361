import java.util.Scanner;

public class SumUntilZeroo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0; // Initialize total sum

        while (true) {
            // Get user input
            System.out.print("Enter a number (0 to stop): ");
            double number = scanner.nextDouble();

            // Check if the user entered 0
            if (number == 0) {
			           break;
            }

            // Add number to total
            total += number;
        }

        // Display total sum
        System.out.println("The total sum is: " + total);
        scanner.close();
    }
}
