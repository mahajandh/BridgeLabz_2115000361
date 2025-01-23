   import java.util.Scanner;

public class FizzBuzz {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the number
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        // Check if the input is a positive integer
        if (num > 0) {
            int i = 1;
            
            // Loop from 1 to the entered number using while loop
            while (i <= num) {
                // Check if the number is divisible by both 3 and 5
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                }
                // Check if the number is divisible by 3
                else if (i % 3 == 0) {
                    System.out.println("Fizz");
                }
                // Check if the number is divisible by 5
                else if (i % 5 == 0) {
                    System.out.println("Buzz");
                }
                // Print the number itself if it's not divisible by 3 or 5
                else {
                    System.out.println(i);
                }
                i++;
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }

        scanner.close();
    }
}
