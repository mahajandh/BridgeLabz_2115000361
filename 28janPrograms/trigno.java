public class TrigonometricFunctions {



    // Method to calculate sine, cosine, and tangent of the angle
    public static double[] calculateTrigonometricFunctions(double angle) {
        // Convert the angle from degrees to radians
        double radians = Math.toRadians(angle);
        
        // Calculate sine, cosine, and tangent using Math class
        double[] results = new double[3];
        results[0] = Math.sin(radians);   // Sine of the angle
        results[1] = Math.cos(radians);   // Cosine of the angle
        results[2] = Math.tan(radians);   // Tangent of the angle
        
        return results;
    }

    public static void main(String[] args) {
        double angle = 45; // Example angle in degrees
        
        // Call the method to calculate trigonometric functions
        double[] results = calculateTrigonometricFunctions(angle);

        // Display the results
        System.out.println("For angle " + angle + " degrees:");
        System.out.println("Sine: " + results[0]);
        System.out.println("Cosine: " + results[1]);
        System.out.println("Tangent: " + results[2]);
    }
}