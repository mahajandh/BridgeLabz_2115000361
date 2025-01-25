import java.util.Scanner;

public class YoungestTallestFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] age = new int[3];
        double[] height = new double[3];
        String[] names = {"Amar", "Akbar", "Anthony"};
        
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter age of " + names[i] + ":");
            age[i] = scanner.nextInt();
            System.out.println("Enter height of " + names[i] + " in cm:");
            height[i] = scanner.nextDouble();
        }
        
        int youngestIndex = 0;
        int tallestIndex = 0;
        
        for (int i = 1; i < 3; i++) {
            if (age[i] < age[youngestIndex]) {
                youngestIndex = i;
            }
            if (height[i] > height[tallestIndex]) {
                tallestIndex = i;
            }
        }
        
        System.out.println("The youngest among them is: " + names[youngestIndex]);
        System.out.println("The tallest among them is: " + names[tallestIndex]);
        
        scanner.close();
    }
}

    
