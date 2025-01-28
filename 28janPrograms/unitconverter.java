public class UnitConverter {

    // Method to convert kilometers to miles
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    // Method to convert miles to kilometers
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    // Method to convert meters to feet
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    // Method to convert feet to meters
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static void main(String[] args) {
        // Example usage:
        double km = 10.0;
        double miles = 6.0;
        double meters = 5.0;
        double feet = 15.0;

        System.out.println(km + " kilometers = " + convertKmToMiles(km) + " miles.");
        System.out.println(miles + " miles = " + convertMilesToKm(miles) + " kilometers.");
        System.out.println(meters + " meters = " + convertMetersToFeet(meters) + " feet.");
        System.out.println(feet + " feet = " + convertFeetToMeters(feet) + " meters.");
    }
}
