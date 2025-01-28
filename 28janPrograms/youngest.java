
import java.util.Scanner;

public class YoungestAndTallest {

    // Method to find the youngest among 3 friends
    public static String findYoungest(int[] ages) {
        int minAge = ages[0];
        int youngestIndex = 0;
        
        // Find the minimum age (youngest)
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                youngestIndex = i;
            }
        }
        
        // Return the name of the youngest friend
        switch (youngestIndex) {
            case 0:
                return "Amar";
            case 1:
                return "Akbar";
            case 2:
                return "Anthony";
            default:
                return "";
        }
    }

    // Method to find the tallest among 3 friends
    public static String findTallest(double[] heights) {
        double maxHeight = heights[0];
        int tallestIndex = 0;
        
        // Find the maximum height (tallest)
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallestIndex = i;
            }
        }
        
        // Return the name of the tallest friend
        switch (tallestIndex) {
            case 0:
                return "Amar";
            case 1:
                return "Akbar";
            case 2:
                return "Anthony";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays to store the age and height of 3 friends
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Input age and height for Amar, Akbar, and Anthony
        System.out.print("Enter age of Amar: ");
        ages[0] = scanner.nextInt();
        System.out.print("Enter height of Amar (in meters): ");
        heights[0] = scanner.nextDouble();

        System.out.print("Enter age of Akbar: ");
        ages[1] = scanner.nextInt();
        System.out.print("Enter height of Akbar (in meters): ");
        heights[1] = scanner.nextDouble();

        System.out.print("Enter age of Anthony: ");
        ages[2] = scanner.nextInt();
        System.out.print("Enter height of Anthony (in meters): ");
        heights[2] = scanner.nextDouble();

        // Find the youngest and tallest
        String youngest = findYoungest(ages);
        String tallest = findTallest(heights);

        // Display the results
        System.out.println("The youngest among the three friends is: " + youngest);
        System.out.println("The tallest among the three friends is: " + tallest);

        // Close the scanner
        scanner.close();
    }
}

