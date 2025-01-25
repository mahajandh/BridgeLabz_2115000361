
import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of persons:");
        int n = scanner.nextInt();
        
        double[][] personData = new double[n][3]; // [height, weight, BMI]
        String[] weightStatus = new String[n];
        
        for (int i = 0; i < n; i++) {
            do {
                System.out.println("Enter height (in meters) of person " + (i + 1) + " (positive value):");
                personData[i][0] = scanner.nextDouble();
            } while (personData[i][0] <= 0);
            
            do {
                System.out.println("Enter weight (in kg) of person " + (i + 1) + " (positive value):");
                personData[i][1] = scanner.nextDouble();
            } while (personData[i][1] <= 0);
            
            personData[i][2] = personData[i][1] / (personData[i][0] * personData[i][0]);
            
            if (personData[i][2] < 18.5)
                weightStatus[i] = "Underweight";
            else if (personData[i][2] < 24.9)
                weightStatus[i] = "Normal weight";
            else if (personData[i][2] < 39.9)
                weightStatus[i] = "Overweight";
            else
                weightStatus[i] = "Obese";
        }
        
        System.out.println("Height (m)\tWeight (kg)\tBMI\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s\n", personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
        
        scanner.close();
    }
}

