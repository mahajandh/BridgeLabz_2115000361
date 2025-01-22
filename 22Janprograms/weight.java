import java.util.Scanner;

public class WeightConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input weight in pounds
        System.out.print("Enter weight in pounds: ");
        double weightInPounds = scanner.nextDouble();

        // Convert pounds to kilograms
        double weightInKilograms = weightInPounds * 2.2;

        // Output the result
        System.out.println("The weight of the person in pound is " + weightInPounds + " and in kg is " + weightInKilograms);
    }
}

