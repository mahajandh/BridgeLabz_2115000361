public class NumberChecker {

    // Method to find the factors of a number and return them as an array
    public static int[] findFactors(int number) {
        int count = 0;
        
        // Counting the number of factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        
        // Creating an array to store factors
        int[] factors = new int[count];
        int index = 0;
        
        // Storing factors in the array
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        
        return factors;
    }

    // Method to find the greatest factor using the factors array
    public static int greatestFactor(int[] factors) {
        return factors[factors.length - 1];  // The largest factor is the last element
    }

    // Method to find the sum of the factors using the factors array
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // Method to find the product of the factors using the factors array
    public static int productOfFactors(int[] factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // Method to find the product of cubes of the factors using the factors array
    public static double productOfCubesOfFactors(int[] factors) {
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);  // Cube of each factor
        }
        return product;
    }

    // Method to check if a number is a perfect number
    public static boolean isPerfectNumber(int number) {
        int[] factors = findFactors(number);
        int sum = sumOfFactors(factors) - number;  // Exclude the number itself
        return sum == number;
    }

    // Method to check if a number is an abundant number
    public static boolean isAbundantNumber(int number) {
        int[] factors = findFactors(number);
        int sum = sumOfFactors(factors) - number;  // Exclude the number itself
        return sum > number;
    }

    // Method to check if a number is a deficient number
    public static boolean isDeficientNumber(int number) {
        int[] factors = findFactors(number);
        int sum = sumOfFactors(factors) - number;  // Exclude the number itself
        return sum < number;
    }

    // Method to check if a number is a strong number
    public static boolean isStrongNumber(int number) {
        int originalNumber = number;
        int sumOfFactorials = 0;

        while (number > 0) {
            int digit = number % 10;
            sumOfFactorials += factorial(digit);  // Add factorial of each digit
            number /= 10;
        }

        return sumOfFactorials == originalNumber;
    }

    // Helper method to calculate factorial of a number
    private static int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    // Main method to test the different methods
    public static void main(String[] args) {
        int number = 145;  // Example number to check

        // Finding factors
        int[] factors = findFactors(number);
        System.out.println("Factors of " + number + ": ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();

        // Finding the greatest factor
        System.out.println("Greatest factor: " + greatestFactor(factors));

        // Finding sum of factors
        System.out.println("Sum of factors: " + sumOfFactors(factors));

        // Finding product of factors
        System.out.println("Product of factors: " + productOfFactors(factors));

        // Finding product of cubes of the factors
        System.out.println("Product of cubes of factors: " + productOfCubesOfFactors(factors));

        // Checking if the number is a perfect number
        System.out.println("Is " + number + " a perfect number? " + isPerfectNumber(number));

        // Checking if the number is an abundant number
        System.out.println("Is " + number + " an abundant number? " + isAbundantNumber(number));

        // Checking if the number is a deficient number
        System.out.println("Is " + number + " a deficient number? " + isDeficientNumber(number));

        // Checking if the number is a strong number
        System.out.println("Is " + number + " a strong number? " + isStrongNumber(number));
    }
}
