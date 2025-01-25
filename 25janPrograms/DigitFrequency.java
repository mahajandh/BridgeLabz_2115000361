
import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Taking input number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Array to store the frequency of each digit (0-9)
        int[] frequency = new int[10];
        
        // Finding the digits and updating the frequency array
        while (number > 0) {
            int digit = number % 10;
            frequency[digit]++;
            number = number / 10;
        }
        
        // Display the frequency of each digit
        System.out.println("Digit frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + ": " + frequency[i]);
            }
        }
        
        sc.close();
    }
}

