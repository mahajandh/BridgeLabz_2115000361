import java.util.Scanner;

public class QuotientAndRemainder {

    // Method to find the quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int[] result = new int[2];
        
        // Calculate quotient and remainder
        result[0] = number / divisor; // Quotient
        result[1] = number % divisor; // Remainder
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for the two numbers
        System.out.print("Enter the number: ");
        int number = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        // Call the method to find quotient and remainder
        int[] result = findRemainderAndQuotient(number, divisor);

        // Display the quotient and remainder
        System.out.println("The quotient is: " + result[0]);
        System.out.println("The remainder is: " + result[1]);

        scanner.close();
    }
}

