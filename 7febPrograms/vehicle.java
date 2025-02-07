class Vehicle {
    int maxSpeed;
    String fuelType;

    // Constructor
    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    // Method to display vehicle information
    void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Subclass: Car
class Car extends Vehicle {
    int seatCapacity;

    // Constructor
    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    // Overriding displayInfo method
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

// Subclass: Truck
class Truck extends Vehicle {
    double loadCapacity;

    // Constructor
    Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    // Overriding displayInfo method
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

// Subclass: Motorcycle
class Motorcycle extends Vehicle {
    boolean hasSidecar;

    // Constructor
    Motorcycle(int maxSpeed, String fuelType, boolean hasSidecar) {
        super(maxSpeed, fuelType);
        this.hasSidecar = hasSidecar;
    }

    // Overriding displayInfo method
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
}

// Main Class to test Vehicle and Transport System
public class VehicleTransportSystem {
    public static void main(String[] args) {
        // Creating objects of each vehicle type
        Vehicle car = new Car(180, "Petrol", 5);
        Vehicle truck = new Truck(120, "Diesel", 10);
        Vehicle motorcycle = new Motorcycle(150, "Petrol", true);

        // Storing objects in an array of Vehicle type (polymorphism)
        Vehicle[] vehicles = {car, truck, motorcycle};

        // Displaying details of each vehicle
        for (Vehicle vehicle : vehicles) {
            System.out.println("\nVehicle Info:");
            vehicle.displayInfo();
            System.out.println();
        }
    }
}

