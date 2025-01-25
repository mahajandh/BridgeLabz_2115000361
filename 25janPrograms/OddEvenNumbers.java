import java.util.Scanner;

public class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input from the user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Check if the input is a natural number (positive integer)
        if (number <= 0) {
            System.out.println("Error: Please enter a valid natural number greater than 0.");
            return; // Exit the program if the number is not valid
        }
        
        // Calculate the size of the arrays (for odd and even numbers)
        int size = number / 2 + 1;  // Maximum size for odd/even arrays
        
        // Create arrays for odd and even numbers
        int[] oddNumbers = new int[size];
        int[] evenNumbers = new int[size];
        
        // Initialize index variables
        int oddIndex = 0, evenIndex = 0;
        
        // Iterate from 1 to the number and populate the odd and even arrays
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex++] = i;  // Save even number
            } else {
                oddNumbers[oddIndex++] = i;    // Save odd number
            }
        }
        
        // Print the odd numbers array
        System.out.print("Odd Numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        System.out.println();
        
        // Print the even numbers array
        System.out.print("Even Numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();
        
        sc.close();
    }
}