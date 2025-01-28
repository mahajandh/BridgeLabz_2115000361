
import java.util.Scanner;

public class HandshakeCalculator {
    // Method to calculate maximum handshakes
    static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        // Handling case when N is less than 2
        if (n < 2) {
            System.out.println("Handshakes are not possible with less than 2 students.");
        } else {
            int handshakes = calculateHandshakes(n);
            System.out.println("The maximum number of handshakes among " + n + " students is: " + handshakes);
        }

        scanner.close();
    }
}

