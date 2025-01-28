import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI for each person
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < 10; i++) {
            double weight = data[i][0];  // weight in kg
            double heightInMeters = data[i][1] / 100;  // height in meters
            double bmi = weight / (heightInMeters * heightInMeters);
            data[i][2] = bmi;  // store BMI in the third column of the array
        }
    }

    // Method to determine BMI status for each person
    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[10];
        
        for (int i = 0; i < 10; i++) {
            double bmi = data[i][2];  // BMI of the person
            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                status[i] = "Normal weight";
            } else if (bmi >= 25 && bmi < 29.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 2D array to store weight, height, and BMI of each person
        double[][] personData = new double[10][3];

        // Taking input for weight and height of 10 persons
        System.out.println("Enter the weight (in kg) and height (in cm) for 10 persons:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            personData[i][0] = scanner.nextDouble();  // input weight in kg
            System.out.print("Height (cm): ");
            personData[i][1] = scanner.nextDouble();  // input height in cm
        }

        // Calculate BMI for each person
        calculateBMI(personData);

        // Get BMI status for each person
        String[] bmiStatus = getBMIStatus(personData);

        // Display the details of each person
        System.out.println("\nPerson\tWeight (kg)\tHeight (cm)\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%s\n", 
                              (i + 1), 
                              personData[i][0], 
                              personData[i][1], 
                              personData[i][2], 
                              bmiStatus[i]);
        }

        // Close scanner
        scanner.close();
    }
}
