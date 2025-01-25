
import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take user input for the number
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        
        // Check if the number is positive
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            return; // Exit the program if the number is not positive
        }
        
        // Create a String array to store the results
        String[] results = new String[number + 1];
        
        // Loop from 0 to the number and populate the results array
        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                results[i] = "Fizz";
            } else if (i % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(i); // Save the number as a string
            }
        }
        
        // Display the results in the format "Position i = result"
        for (int i = 1; i <= number; i++) {
            System.out.println("Position " + i + " = " + results[i]);
        }
        
        sc.close();
    }
}

