
import java.util.Scanner;

public class OddEvenNumbers {

    // Function to check if the input is a natural number
    public static boolean isNaturalNumber(String input) {
        try {
            int num = Integer.parseInt(input);
            return num > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a number: ");
        String input = scanner.nextLine();

        // Validate if the input is a natural number
        if (isNaturalNumber(input)) {
            int n = Integer.parseInt(input);
            
            System.out.println("Even numbers between 1 and " + n + ":");
            // Printing even numbers using for loop
            for (int i = 2; i <= n; i += 2) {
                System.out.print(i + " ");
            }
            
            System.out.println("\nOdd numbers between 1 and " + n + ":");
            // Printing odd numbers using for loop
            for (int i = 1; i <= n; i += 2) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println("Please enter a valid natural number.");
        }

        scanner.close();
    }
}

