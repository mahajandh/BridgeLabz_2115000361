
import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get user input
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        // Initialize variables
        int sum = 0, originalNumber = number;
        
        // Process each digit
        while (originalNumber != 0) {
            int remainder = originalNumber % 10; // Get last digit
            sum += remainder * remainder * remainder; // Cube and add to sum
            originalNumber /= 10; // Remove last digit
        }
        
        // Check if the number is Armstrong
        if (sum == number) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }
        
        scanner.close();
    }
}

