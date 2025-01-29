import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        // Create a scanner to take input
        Scanner scanner = new Scanner(System.in);

        // Prompt for the user to input a date
        System.out.print("Enter a date (yyyy-mm-dd): ");
        String inputDate = scanner.nextLine();

        // Parse the input date to LocalDate
        LocalDate date = LocalDate.parse(inputDate);

        // Add 7 days, 1 month, and 2 years
        LocalDate result = date.plusDays(7).plusMonths(1).plusYears(2);

        // Subtract 3 weeks
        result = result.minusWeeks(3);

        // Display the final result
        System.out.println("New date after arithmetic: " + result);
    }
}
