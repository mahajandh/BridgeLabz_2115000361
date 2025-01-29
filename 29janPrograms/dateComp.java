import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        // Create a scanner to take input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input two dates
        System.out.print("Enter the first date (yyyy-mm-dd): ");
        String inputDate1 = scanner.nextLine();
        
        System.out.print("Enter the second date (yyyy-mm-dd): ");
        String inputDate2 = scanner.nextLine();

        // Parse the input dates to LocalDate
        LocalDate date1 = LocalDate.parse(inputDate1);
        LocalDate date2 = LocalDate.parse(inputDate2);

        // Compare the dates
        if (date1.isBefore(date2)) {
            System.out.println("The first date is before the second date.");
        } else if (date1.isAfter(date2)) {
            System.out.println("The first date is after the second date.");
        } else if (date1.isEqual(date2)) {
            System.out.println("The first date is the same as the second date.");
        }
    }
}

