public class EarthVolumeCalculator {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double conversionFactor = 1.609; // 1 mile = 1.609 km
        double radiusMiles = radiusKm / conversionFactor;
        
        double volumeKm3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);
        double volumeMiles3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusMiles, 3);

        System.out.println("The volume of Earth in cubic kilometers is " + volumeKm3 + " and cubic miles is " + volumeMiles3);
    }
}