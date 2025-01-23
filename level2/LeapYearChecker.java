
import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year (>= 1582): ");
        int year = scanner.nextInt();
        scanner.close();

        if (year < 1582) {
            System.out.println("Year must be >= 1582.");
            return;
        }

        // Approach 1: Multiple if-else statements
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year + " is a Leap Year.");
                } else {
                    System.out.println(year + " is NOT a Leap Year.");
                }
            } else {
                System.out.println(year + " is a Leap Year.");
            }
        } else {
            System.out.println(year + " is NOT a Leap Year.");
        }

        // Approach 2: Single if statement with logical operators
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("[Logical Approach] " + year + " is a Leap Year.");
        } else {
            System.out.println("[Logical Approach] " + year + " is NOT a Leap Year.");
        }
    }
}

