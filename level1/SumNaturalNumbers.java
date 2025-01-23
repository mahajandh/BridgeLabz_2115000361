import java.util.Scanner;

public class SumNaturalNumbers {
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
            
            // Using the formula to compute the sum of first n natural numbers
            int formulaSum = n * (n + 1) / 2;
            
            // Using a for loop to compute the sum of first n natural numbers
            int loopSum = 0;
            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }
            
            // Compare and print the results
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using for loop: " + loopSum);
        } else {
            System.out.println("Please enter a valid natural number.");
        }

        scanner.close();
    }
}
