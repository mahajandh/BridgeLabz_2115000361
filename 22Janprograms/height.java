import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your height in centimeters: ");
        double heightCm = input.nextDouble();
        
        double heightInInches = heightCm / 2.54;  // Convert cm to inches
        int feet = (int) (heightInInches / 12);   // Convert inches to feet
        int inches = (int) (heightInInches % 12); // Remaining inches

        System.out.println("Your Height in cm is " + heightCm + " while in feet is " + feet + " and inches is " + inches);
        
        input.close();
		}
	}