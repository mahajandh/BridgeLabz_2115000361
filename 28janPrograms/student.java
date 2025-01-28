import java.util.Scanner;

public class StudentVoteChecker {

    // Method to check if a student can vote based on their age
    public boolean canStudentVote(int age) {
        // Validate age for negative value
        if (age < 0) {
            return false; // Negative age is invalid, cannot vote
        }
        // Check if age is 18 or greater
        if (age >= 18) {
            return true; // Eligible to vote
        } else {
            return false; // Not eligible to vote
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();
        
        // Array to store the ages of 10 students
        int[] ages = new int[10];
        
        // Loop through the array and take input for each student's age
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
            
            // Check if the student can vote
            boolean canVote = checker.canStudentVote(ages[i]);
            
            // Output the result
            if (canVote) {
                System.out.println("Student " + (i + 1) + " can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " cannot vote.");
            }
        }
        
        // Close the scanner
        scanner.close();
    }
}
