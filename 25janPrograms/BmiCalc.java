import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of persons:");
        int n = scanner.nextInt();
        
        double[] height = new double[n];
        double[] weight = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter height (in meters) of person " + (i + 1) + ":");
            height[i] = scanner.nextDouble();
            
            System.out.println("Enter weight (in kg) of person " + (i + 1) + ":");
            weight[i] = scanner.nextDouble();
            
            bmi[i] = weight[i] / (height[i] * height[i]);
            
            if (bmi[i] < 18.5)
                status[i] = "Underweight";
            else if (bmi[i] < 24.9)
                status[i] = "Normal weight";
            else if (bmi[i] < 39.9)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }
        
        System.out.println("Height (m)\tWeight (kg)\tBMI\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s\n", height[i], weight[i], bmi[i], status[i]);
        }
        
        scanner.close();
    }
}

