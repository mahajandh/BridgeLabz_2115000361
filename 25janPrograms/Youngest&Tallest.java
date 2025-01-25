
import java.util.Scanner;

public class YoungestAndTallestFriend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter age of " + friends[i] + ":");
            ages[i] = scanner.nextInt();
            System.out.println("Enter height (in cm) of " + friends[i] + ":");
            heights[i] = scanner.nextDouble();
        }
        
        // Find the youngest friend
        int minAge = ages[0];
        String youngest = friends[0];
        for (int i = 1; i < 3; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                youngest = friends[i];
            }
        }
        
        // Find the tallest friend
        double maxHeight = heights[0];
        String tallest = friends[0];
        for (int i = 1; i < 3; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallest = friends[i];
            }
        }
        
        System.out.println("Youngest friend: " + youngest + " (" + minAge + " years old)");
        System.out.println("Tallest friend: " + tallest + " (" + maxHeight + " cm)");
        
        scanner.close();
    }
}

