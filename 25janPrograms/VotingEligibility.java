
import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Define an array to store the ages of 10 students
        int[] ages = new int[10];
        
        // Take user input for each student's age
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter the age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }
        
        // Check voting eligibility for each student
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            
            // Check for invalid age
            if (age < 0) {
                System.out.println("Invalid age entered for student " + (i + 1));
            }
            // Check if the student can vote
            else if (age >= 18) {
                System.out.println("The student with age " + age + " can vote.");
            }
            // If age is less than 18
            else {
                System.out.println("The student with age " + age + " cannot vote.");
            }
        }
        
        sc.close();
    }
}

