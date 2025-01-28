import java.util.Random;

public class StudentScoreCard {

    // Method to generate random scores for Physics, Chemistry, and Maths
    public static int[][] generateScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][3]; // 2D array for PCM scores

        for (int i = 0; i < numStudents; i++) {
            // Generate random 2-digit scores (between 10 and 99)
            scores[i][0] = 10 + rand.nextInt(90);  // Physics score
            scores[i][1] = 10 + rand.nextInt(90);  // Chemistry score
            scores[i][2] = 10 + rand.nextInt(90);  // Maths score
        }

        return scores;
    }

    // Method to calculate the total, average, and percentage for each student
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][4]; // [total, average, percentage]

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];  // Total score
            double average = total / 3.0;  // Average score
            double percentage = (total / 300.0) * 100;  // Percentage (out of 300)

            // Round off the values to 2 decimal places
            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return results;
    }

    // Method to display the scorecard of all students
    public static void displayScoreCard(int[][] scores, double[][] results) {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("| Student | Physics | Chemistry | Maths | Total | Average | Percentage |");
        System.out.println("-------------------------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("| %-8d | %-7d | %-9d | %-5d | %-5.2f | %-7.2f | %-10.2f |\n", 
                i + 1, 
                scores[i][0], 
                scores[i][1], 
                scores[i][2], 
                results[i][0], 
                results[i][1], 
                results[i][2]);
        }

        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        int numStudents = 5; // Number of students

        // Step 1: Generate random scores for all students
        int[][] scores = generateScores(numStudents);

        // Step 2: Calculate the total, average, and percentage for each student
        double[][] results = calculateResults(scores);

        /
		}
		}
