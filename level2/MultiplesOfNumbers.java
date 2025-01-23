import java.util.Scanner;

public class MultiplesOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
		 System.out.println("Multiples of " + number + " below 100 are:");
        for (int i = 100; i >= 1; i--) {
            if (i % number == 0) {
                System.out.println(i);
            }
        }

        scanner.close();
    }
}