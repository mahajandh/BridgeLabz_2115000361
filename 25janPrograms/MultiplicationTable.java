
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get user input for the number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Define an array to store multiplication results
        int[] multiplicationTable = new int[10];
        
        // Generate the multiplication table and store in the array
        for (int i = 1; i <= 10; i++) {
            multiplicationTable[i - 1] = number * i;
        }
        
        // Display the multiplication table
        for (int i = 0; i < multiplicationTable.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + multiplicationTable[i]);
        }
        
        sc.close();
    }
}

