
import java.util.Scanner;

public class NumberStorage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Define an array of 10 elements and other necessary variables
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        
        // Infinite loop to get user input
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double number = sc.nextDouble();
            
            // Break the loop if number is 0 or negative or if array is full
            if (number <= 0 || index == 10) {
                break;
            }
            
            // Store the number in the array and increment the index
            numbers[index] = number;
            index++;
        }
        
        // Display all the numbers entered and calculate the total
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }
        
        // Display the total sum of numbers
        System.out.println("Total sum: " + total);
        
        sc.close();
    }
}

