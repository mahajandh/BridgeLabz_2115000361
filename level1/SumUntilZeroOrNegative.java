import java.util.Scanner;

public class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        
        // Infinite loop to take multiple inputs
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            int number = scanner.nextInt();
            
            // Break the loop if number is 0 or negative
            if (number <= 0) {
                break;
            }
            
            sum += number; // Add number to sum
        }
        
        System.out.println("Total Sum: " + sum);
        scanner.close();
    }
}