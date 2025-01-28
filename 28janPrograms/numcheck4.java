public class NumberChecker {

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a number is a neon number
    public static boolean isNeon(int number) {
        int square = number * number;
        int sumOfDigits = 0;

        // Sum of digits of the square of the number
        while (square > 0) {
            sumOfDigits += square % 10;
            square /= 10;
        }

        // Check if sum of digits equals the number itself
        return sumOfDigits == number;
    }

    // Method to check if a number is a spy number
    public static boolean isSpy(int number) {
        int sum = 0;
        int product = 1;
        int originalNumber = number;

        // Loop through the digits of the number
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            product *= digit;
            number /= 10;
        }

        // Check if sum and product of digits are equal
        return sum == product;
    }

    // Method to check if a number is an automorphic number
    public static boolean isAutomorphic(int number) {
        int square = number * number;
        String strNumber = String.valueOf(number);
        String strSquare = String.valueOf(square);

        // Check if the square ends with the number itself
        return strSquare.endsWith(strNumber);
    }

    // Method to check if a number is a buzz number
    public static boolean isBuzz(int number) {
        return number % 7 == 0 || String.valueOf(number).endsWith("7");
    }

    // Main method to test the different methods
    public static void main(String[] args) {
        int number = 37; // Example number

        // Check if the number is prime
        System.out.println("Is " + number + " a prime number? " + isPrime(number));

        // Check if the number is a neon number
        System.out.println("Is " + number + " a neon number? " + isNeon(number));

        // Check if the number is a spy number
        System.out.println("Is " + number + " a spy number? " + isSpy(number));

        // Check if the number is an automorphic number
        System.out.println("Is " + number + " an automorphic number? " + isAutomorphic(number));

        // Check if the number is a buzz number
        System.out.println("Is " + number + " a buzz number? " + isBuzz(number));
    }
}
