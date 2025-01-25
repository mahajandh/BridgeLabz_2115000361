import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take integer input for the number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Define an array to store the multiplication results from 6 to 9
        int[] multiplicationResult = new int[4];
        
        // Calculate the multiplication table from 6 to 9 and store it in the array
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
        }
        
        // Display the multiplication results in the format number * i = result
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 6]);
        }
		     sc.close();
    }
}

