
import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number (n): ");
        int n = scanner.nextInt();

        // Check if the number is a natural number
        if (n <= 0) {
            System.out.println("Please enter a valid natural number greater than 0.");
            return;
        }

        // Compute sum using while loop
        int sumUsingWhileLoop = 0;
        int i = 1;
        while (i <= n) {
            sumUsingWhileLoop += i;
            i++;
        }

        // Compute sum using the formula n*(n+1)/2
        int sumUsingFormula = n * (n + 1) / 2;

        // Compare the two results
        System.out.println("Sum using while loop: " + sumUsingWhileLoop);
        System.out.println("Sum using formula: " + sumUsingFormula);

        if (sumUsingWhileLoop == sumUsingFormula) {
            System.out.println("Both results are correct!");
        } else {
            System.out.println("There is an error in the calculation.");
        }
    }
}

