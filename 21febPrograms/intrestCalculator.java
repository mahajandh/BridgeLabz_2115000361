public class InterestCalculator {
    // Method that throws an exception if input is invalid
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return amount * rate * years / 100; // Simple Interest formula
    }

    public static void main(String[] args) {
        try {
            double interest = calculateInterest(1000, 5, 2); // Valid input
            System.out.println("Calculated Interest: " + interest);

            double invalidInterest = calculateInterest(-500, 5, 2); // Invalid input
            System.out.println("Calculated Interest: " + invalidInterest);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
