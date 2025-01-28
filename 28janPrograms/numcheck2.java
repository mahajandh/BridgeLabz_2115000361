import java.util.Arrays;

public class NumberChecker {

    // Method to find the count of digits in the number
    public static int countDigits(int number) {
        return Integer.toString(number).length();
    }

    // Method to store the digits of the number in a digits array
    public static int[] storeDigits(int number) {
        int numDigits = countDigits(number);
        int[] digits = new int[numDigits];
        for (int i = numDigits - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    // Method to find the sum of the digits of the number using the digits array
    public static int sumOfDigits(int number) {
        int[] digits = storeDigits(number);
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    // Method to find the sum of the squares of the digits of a number using the digits array
    public static double sumOfSquaresOfDigits(int number) {
        int[] digits = storeDigits(number);
        double sumOfSquares = 0;
        for (int digit : digits) {
            sumOfSquares += Math.pow(digit, 2);
        }
        return sumOfSquares;
    }

    // Method to check if a number is a Harshad number using the digits array
    public static boolean isHarshadNumber(int number) {
        int sum = sumOfDigits(number);
        return number % sum == 0;
    }

    // Method to find the frequency of each digit in the number
    public static int[][] digitFrequency(int number) {
        int[] digits = storeDigits(number);
        int[][] frequency = new int[10][2]; // 10 for digits 0-9

        // Initialize the frequency array
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i; // store digit
            frequency[i][1] = 0; // initialize frequency to 0
        }

        // Count the frequency of each digit
        for (int digit : digits) {
            frequency[digit][1]++;
        }
        
        return frequency;
    }

    // Method to display the frequency of digits
    public static void displayFrequency(int[][] frequency) {
        for (int[] row : frequency) {
            if (row[1] > 0) {
                System.out.println("Digit " + row[0] + " appears " + row[1] + " times.");
            }
        }
    }

    public static void main(String[] args) {
        int number = 21; // Example number

        // Find the count of digits
        int digitCount = countDigits(number);
        System.out.println("Count of digits: " + digitCount);

        // Store and display the digits of the number
        int[] digits = storeDigits(number);
        System.out.println("Digits: " + Arrays.toString(digits));

        // Find the sum of digits
        int sumOfDigits = sumOfDigits(number);
        System.out.println("Sum of digits: " + sumOfDigits);

        // Find the sum of squares of digits
        double sumOfSquares = sumOfSquaresOfDigits(number);
        System.out.println("Sum of squares of digits: " + sumOfSquares);

        // Check if the number is a Harshad number
        boolean isHarshad = isHarshadNumber(number);
        System.out.println("Is Harshad Number: " + isHarshad);

        // Find the frequency of each digit and display it
        int[][] frequency = digitFrequency(number);
        displayFrequency(frequency);
    }
}
