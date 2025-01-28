import java.util.Scanner;

public class SumOfNaturalNumbers {

    // Method to calculate the sum of first n natural numbers using a loop
    static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;  // Add current number to sum
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for the value of n
        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();

        // Checking if the input is a positive number
        if (n < 1) {
            System.out.println("Please enter a positive integer.");
        } else {
            // Calculate the sum using the method
            int sum = calculateSum(n);
            // Display the result
            System.out.println("The sum of first " + n + " natural numbers is: " + sum);
        }

        scanner.close();
    }
}
