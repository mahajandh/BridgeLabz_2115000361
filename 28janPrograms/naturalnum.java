
import java.util.Scanner;

public class SumOfNaturalNumbers {

    // Method to find the sum of n natural numbers using recursion
    public static int findSumRecursively(int n) {
        // Base case: If n is 1, return 1
        if (n == 1) {
            return 1;
        }
        // Recursive case: Sum of n natural numbers = n + sum of (n-1) numbers
        return n + findSumRecursively(n - 1);
    }

    // Method to find the sum of n natural numbers using the formula
    public static int findSumUsingFormula(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for the number
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        // Check if the number is a natural number
        if (n <= 0) {
            System.out.println("Please enter a positive integer (natural number).");
            return;
        }

        // Find the sum using recursion
        int sumRecursive = findSumRecursively(n);

        // Find the sum using the formula
        int sumFormula = findSumUsingFormula(n);

        // Compare the results
        System.out.println("Sum using recursion: " + sumRecursive);
        System.out.println("Sum using formula: " + sumFormula);

        if (sumRecursive == sumFormula) {
            System.out.println("Both results are correct and match.");
        } else {
            System.out.println("There is a discrepancy between the two methods.");
        }

        scanner.close();
    }
}

