import java.util.Scanner;

public class LeapYearChecker {

    // Method to check if the year is a leap year
    public static boolean isLeapYear(int year) {
        // Leap year conditions
        if (year >= 1582) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    // Year is divisible by 400
                    return year % 400 == 0;
                }
                // Year is divisible by 4 but not by 100
                return true;
            }
        }
        // Not a leap year
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for the year
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        // Check if the year is a leap year
        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }

        scanner.close();
    }
}
