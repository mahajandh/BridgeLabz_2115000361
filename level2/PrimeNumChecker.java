import java.util.Scanner;

public class PrimeNumberCheck {
    public static void main(String[] args) {
        // Create a Scanner object to get input from the user
        Scanner scanner = new Scanner(System.in);


        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Check if the number is less than or equal to 1
        if (number <= 1) {
            System.out.println(number + " is not a prime number.");
        } else {
            // Assume the number is prime
            boolean isPrime = true;

            // Loop through numbers from 2 to the entered number - 1
            for (int i = 2; i < number; i++) {
                // Check if the number is divisible by any number other than 1 and itself
                if (number % i == 0) {
                    isPrime = false;
                    break; // If divisible, no need to check further
                }
            }

            // Output the result
            if (isPrime) {
                System.out.println(number + " is a prime number.");
            } else {
                System.out.println(number + " is not a prime number.");
            }
        }

        // Close the scanner
        scanner.close();
    }
}
