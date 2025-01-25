import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Define an array to store the heights of 11 players
        double[] heights = new double[11];
        double sum = 0.0;
        
        // Get input values for the heights of the players
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter the height of player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
            sum += heights[i]; // Add the height to the sum
        }
        
        // Calculate the mean height
        double meanHeight = sum / heights.length;
        
        // Display the mean height
        System.out.println("The mean height of the football team is: " + meanHeight);
        
        sc.close();
    }
}