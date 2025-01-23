import java.util.Scanner;
public class SumUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        for (int number = 1; number != 0; ) {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
            sum += number;
        }

        System.out.println("The sum is: " + sum);
    }
}
