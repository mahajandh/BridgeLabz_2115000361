class Vehicle {
    String model;
    int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

// Refuelable interface
interface Refuelable {
    void refuel();
}

// ElectricVehicle class (composition)
class ElectricVehicle {
    Vehicle vehicle;
    int batteryCapacity;

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        vehicle = new Vehicle(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println("Charging the electric vehicle...");
    }

    public void displayInfo() {
        vehicle.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

// PetrolVehicle class (composition + implements Refuelable)
class PetrolVehicle {
    Vehicle vehicle;
    String fuelType;

    public PetrolVehicle(String model, int maxSpeed, String fuelType) {
        vehicle = new Vehicle(model, maxSpeed);
        this.fuelType = fuelType;
    }

    public void refuel() {
        System.out.println("Refueling the petrol vehicle with " + fuelType + "...");
    }

    public void displayInfo() {
        vehicle.displayInfo();
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Main class to demonstrate the system
public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle electricVehicle = new ElectricVehicle("Tesla Model 3", 250, 75);
        PetrolVehicle petrolVehicle = new PetrolVehicle("Toyota Corolla", 180, "Petrol");

        electricVehicle.displayInfo();
        electricVehicle.charge();

        System.out.println();

        petrolVehicle.displayInfo();
        petrolVehicle.refuel();
    }
}

