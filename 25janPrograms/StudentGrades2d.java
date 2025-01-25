
import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Declare a 2D array to store marks for Physics, Chemistry, and Maths
        int[][] marks = new int[numStudents][3]; // Rows for students, columns for subjects
        double[] percentages = new double[numStudents]; // Array for percentages
        char[] grades = new char[numStudents]; // Array for grades

        // Input marks for each student
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");
            int totalMarks = 0;

            for (int j = 0; j < 3; j++) {
                String subject = j == 0 ? "Physics" : j == 1 ? "Chemistry" : "Maths";
                System.out.print(subject + ": ");
                int mark = scanner.nextInt();

                // Validate marks
                while (mark < 0 || mark > 100) {
                    System.out.println("Invalid marks! Please enter marks between 0 and 100.");
                    System.out.print(subject + ": ");
                    mark = scanner.nextInt();
                }

                marks[i][j] = mark; // Store mark in 2D array
                totalMarks += mark;
            }

            // Calculate percentage and determine grade
            percentages[i] = totalMarks / 3.0;
            grades[i] = getGrade(percentages[i]);
        }

        // Display results
        System.out.println("\nResults:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Physics: " + marks[i][0] + ", Chemistry: " + marks[i][1] + ", Maths: " + marks[i][2]);
            System.out.println("Percentage: " + percentages[i] + "%");
            System.out.println("Grade: " + grades[i]);
            System.out.println();
        }

        scanner.close();
    }

    // Method to determine grade based on percentage
    private static char getGrade(double percentage) {
        if (percentage >= 80) {
            return 'A';
        } else if (percentage >= 70) {
            return 'B';
        } else if (percentage >= 60) {
            return 'C';
        } else if (percentage >= 50) {
            return 'D';
        } else if (percentage >= 40) {
            return 'E';
        } else {
            return 'R';
        }
    }
}

