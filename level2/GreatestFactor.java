import java.util.Scanner;

public class GreatestFactor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Initialize the greatestFactor variable
        int greatestFactor = 1;

        // Loop from number-1 to 1 to find the greatest factor
        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break;
            }
        }

        // Display the greatest factor
        System.out.println("The greatest factor of " + number + " is: " + greatestFactor);

        scanner.close();
    }
}

