
import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Define an array of 5 elements to store the numbers
        int[] numbers = new int[5];
        
        // Get user input for the array
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }
        
        // Check if each number is positive, negative, or zero
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            
            if (num > 0) {
                // Check if the number is even or odd
                if (num % 2 == 0) {
                    System.out.println(num + " is positive and even.");
                } else {
                    System.out.println(num + " is positive and odd.");
                }
            } else if (num < 0) {
                System.out.println(num + " is negative.");
            } else {
                System.out.println(num + " is zero.");
            }
        }
        
        // Compare the first and last elements of the array
        int first = numbers[0];
        int last = numbers[numbers.length - 1];
        
        if (first == last) {
            System.out.println("The first and last elements are equal.");
        } else if (first > last) {
            System.out.println("The first element is greater than the last element.");
        } else {
            System.out.println("The first element is less than the last element.");
        }
        
        sc.close();
    }
}

