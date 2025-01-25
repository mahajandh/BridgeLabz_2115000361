import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] newSalary = new double[10];
        double[] bonusAmount = new double[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;
        
        // Taking input
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter salary of employee " + (i + 1) + ":");
            double s = scanner.nextDouble();
            System.out.println("Enter years of service for employee " + (i + 1) + ":");
            double y = scanner.nextDouble();
            
            if (s <= 0 || y < 0) {
                System.out.println("Invalid input. Please enter again.");
                i--; // Decrement index to re-enter values
                continue;
            }
            salary[i] = s;
            yearsOfService[i] = y;
        }
        
        // Calculating bonus and new salary
        for (int i = 0; i < 10; i++) {
            double bonusPercentage = (yearsOfService[i] > 5) ? 0.05 : 0.02;
            bonusAmount[i] = salary[i] * bonusPercentage;
            newSalary[i] = salary[i] + bonusAmount[i];
            
            totalBonus += bonusAmount[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }
        
        // Displaying results
        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        
        scanner.close();
    }
}