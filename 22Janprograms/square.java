import java.util.Scanner;

public class SquareSideCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Take perimeter as input
        System.out.print("Enter the perimeter of the square: ");
        double perimeter = input.nextDouble();
        
        // Calculate the side of the square (side = perimeter / 4)
        double side = perimeter / 4;
        
        // Output the result
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
        
        input.close();
    }
}

