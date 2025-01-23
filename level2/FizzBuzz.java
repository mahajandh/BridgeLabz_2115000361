import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        // Create a Scanner object to get input from the user
        Scanner scanner = new Scanner(System.in);
   System.out.print("Enter a positive number: ");
        int number = scanner.nextInt();

        // Check if the input is a positive integer
        if (number > 0) {
            // Loop from 1 to the entered number
            for (int i = 1; i <= number; i++) {
                // Check if the number is a multiple of both 3 and 5
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                }
                // Check if the number is a multiple of 3
                else if (i % 3 == 0) {
                    System.out.println("Fizz");
                }
                // Check if the number is a multiple of 5
                else if (i % 5 == 0) {
                    System.out.println("Buzz");
          }
                // Print the number itself
                else {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }

        // Close the scanner
        scanner.close();
    }
}
