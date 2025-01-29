import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int low = 1, high = 100;
        boolean guessedCorrectly = false;
        
        System.out.println("Think of a number between 1 and 100. The computer will try to guess it!");
        
        while (!guessedCorrectly) {
            int guess = generateGuess(low, high, random);
            System.out.println("Is your number " + guess + "? (Enter 'H' for high, 'L' for low, 'C' for correct)");
            
            char feedback = scanner.next().charAt(0);
            
            switch (Character.toUpperCase(feedback)) {
                case 'H':
                    high = guess - 1;
                    break;
                case 'L':
                    low = guess + 1;
                    break;
                case 'C':
                    guessedCorrectly = true;
                    System.out.println("Hooray! The computer guessed your number: " + guess);
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'H', 'L', or 'C'.");
            }
        }
        scanner.close();
    }
    
    private static int generateGuess(int low, int high, Random random) {
        return random.nextInt(high - low + 1) + low;
    }
}


