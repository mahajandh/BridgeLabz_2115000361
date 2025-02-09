import java.util.*;

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm;
    }

    public abstract double calculateFare(double distance);
}

// Interface GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Car class
class Car extends Vehicle implements GPS {
    private String location;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Bike class
class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9; // 10% discount for bikes
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Auto class
class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 1.1; // 10% additional charge for autos
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Main class
public class RideHailingApp {
    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();
        
        Vehicle car = new Car("C101", "Alice", 15);
        Vehicle bike = new Bike("B202", "Bob", 10);
        Vehicle auto = new Auto("A303", "Charlie", 12);
        
        rides.add(car);
        rides.add(bike);
        rides.add(auto);
        
        double distance = 10; // Sample distance
        
        for (Vehicle ride : rides) {
            System.out.println(ride.getVehicleDetails() + " | Fare for " + distance + " km: " + ride.calculateFare(distance));
            
            if (ride instanceof GPS) {
                ((GPS) ride).updateLocation("New Destination");
                System.out.println("Updated Location: " + ((GPS) ride).getCurrentLocation());
            }
        }
    }
}

