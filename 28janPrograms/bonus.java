import java.util.Random;

public class ZaraBonusCalculation {

    // Method to generate random salary and years of service for employees
    public static double[][] generateEmployeeData(int numEmployees) {
        Random rand = new Random();
        double[][] employeeData = new double[numEmployees][2]; // 2D array: [salary, years of service]
        
        for (int i = 0; i < numEmployees; i++) {
            // Generate a random 5-digit salary between 10000 and 99999
            employeeData[i][0] = 10000 + rand.nextInt(90000);
            
            // Generate years of service between 1 and 20
            employeeData[i][1] = 1 + rand.nextInt(20);
        }
        
        return employeeData;
    }

    // Method to calculate the new salary and bonus for employees
    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {
        double[][] newSalaryAndBonus = new double[employeeData.length][3]; // [old salary, new salary, bonus]

        for (int i = 0; i < employeeData.length; i++) {
            double oldSalary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double bonusPercentage;

            // Calculate bonus percentage based on years of service
            if (yearsOfService > 5) {
                bonusPercentage = 0.05;  // 5% bonus for more than 5 years
            } else {
                bonusPercentage = 0.02;  // 2% bonus for 5 years or less
            }

            double bonus = oldSalary * bonusPercentage;
            double newSalary = oldSalary + bonus;

            // Store the old salary, new salary, and bonus in the new array
            newSalaryAndBonus[i][0] = oldSalary;
            newSalaryAndBonus[i][1] = newSalary;
            newSalaryAndBonus[i][2] = bonus;
        }

        return newSalaryAndBonus;
    }

    // Method to calculate the total old salary, total new salary, and total bonus
    public static double[] calculateTotalSalariesAndBonus(double[][] newSalaryAndBonus) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        for (int i = 0; i < newSalaryAndBonus.length; i++) {
            totalOldSalary += newSalaryAndBonus[i][0];
            totalNewSalary += newSalaryAndBonus[i][1];
            totalBonus += newSalaryAndBonus[i][2];
        }

        return new double[]{totalOldSalary, totalNewSalary, totalBonus};
    }

    // Method to display the employee data in a tabular format
    public static void displayTable(double[][] newSalaryAndBonus, double[] totals) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("| Employee | Old Salary | New Salary | Bonus  |");
        System.out.println("---------------------------------------------------------------");
        
        for (int i = 0; i < newSalaryAndBonus.length; i++) {
            System.out.printf("| %-8d | %-10.2f | %-10.2f | %-6.2f |\n", i + 1, newSalaryAndBonus[i][0], newSalaryAndBonus[i][1], newSalaryAndBonus[i][2]);
        }
        
        System.out.println("---------------------------------------------------------------");
        System.out.printf("Total Old Salary: %.2f\n", totals[0]);
        System.out.printf("Total New Salary: %.2f\n", totals[1]);
        System.out.printf("Total Bonus: %.2f\n", totals[2]);
        System.out.println("---------------------------------------------------------------");
    }

    public static void main(String[] args) {
        int numEmployees = 10;
        
        // Step 1: Generate employee data (salary and years of service)
        double[][] employeeData = generateEmployeeData(numEmployees);
        
        // Step 2: Calculate new salary and bonus for each employee
        double[][] newSalaryAndBonus = calculateNewSalaryAndBonus(employeeData);
        
        // Step 3: Calculate total salaries and bonus
        double[] totals = calculateTotalSalariesAndBonus(newSalaryAndBonus);
        
        // Step 4: Display the results in a tabular format
        displayTable(newSalaryAndBonus, totals);
    }
}

