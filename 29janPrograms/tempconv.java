import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Temperature Converter");
        System.out.print("Enter temperature: ");
        double temperature = scanner.nextDouble();
        
        System.out.print("Convert to (C/F): ");
        char unit = scanner.next().charAt(0);
        
        if (Character.toUpperCase(unit) == 'C') {
            System.out.println("Converted temperature: " + fahrenheitToCelsius(temperature) + " °C");
        } else if (Character.toUpperCase(unit) == 'F') {
            System.out.println("Converted temperature: " + celsiusToFahrenheit(temperature) + " °F");
        } else {
            System.out.println("Invalid unit. Please enter C or F.");
        }
        
        scanner.close();
    }
    
    private static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }
    
    private static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
}
