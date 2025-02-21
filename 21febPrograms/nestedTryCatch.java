import java.util.Scanner;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {10, 20, 30, 40, 50};

        try {
            System.out.print("Enter index: ");
            int index = scanner.nextInt();

            try {
                int element = numbers[index]; // May throw ArrayIndexOutOfBoundsException
                System.out.print("Enter divisor: ");
                int divisor = scanner.nextInt();

                int result = element / divisor; // May throw ArithmeticException
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        } finally {
            scanner.close();
        }
    }
}
