public class TriangleAreaCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Get the base and height from the user
        System.out.print("Enter the base of the triangle in inches: ");
        double baseInches = input.nextDouble();
        
        System.out.print("Enter the height of the triangle in inches: ");
        double heightInches = input.nextDouble();
        
        // Calculate the area in square inches
        double areaInches = 0.5 * baseInches * heightInches;

        // Convert area to square centimeters (1 inch = 2.54 cm)
        double areaCm = areaInches * Math.pow(2.54, 2);
        
        // Output the result
        System.out.println("The area of the triangle is " + areaInches + " square inches and " + areaCm + " square centimeters.");
        
        input.close();
    }
}