import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		  System.out.print("Enter weight in kg: ");
        double weight = scanner.nextDouble();
        
        System.out.print("Enter height in cm: ");
        double heightCm = scanner.nextDouble();
        
        // Convert height to meters
        double heightM = heightCm / 100;
        
        // Calculate BMI
        double bmi = weight / (heightM * heightM);
        
        // Determine weight status
        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 24.9) {
            status = "Normal weight";
        } else if (bmi < 29.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        
        // Output results
        System.out.println("\nBMI: " + bmi);
        System.out.println("Weight Status: " + status);
        
        scanner.close();
    }
}

