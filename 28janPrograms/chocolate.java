import java.util.Scanner;

public class ChocolatesDistribution {

    // Method to find the number of chocolates each child gets and the remaining chocolates
    public static int[] findRemainderAndQuotient(int numberOfChocolates, int numberOfChildren) {
        int[] result = new int[2];
        
        // Calculate the number of chocolates each child gets (quotient)
        result[0] = numberOfChocolates / numberOfChildren; // Chocolates each child gets
        // Calculate the remaining chocolates (remainder)
        result[1] = numberOfChocolates % numberOfChildren; // Remaining chocolates
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for the number of chocolates and children
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();

        // Call the method to find chocolates each child gets and remaining chocolates
        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        // Display the result
        System.out.println("Each child gets: " + result[0] + " chocolates.");
        System.out.println("Remaining chocolates: " + result[1]);

        scanner.close();
    }
}

