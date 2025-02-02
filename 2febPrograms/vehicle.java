class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 100.0; // Fixed registration fee for all vehicles

    // Constructor
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }

    // Class method to update the registration fee
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        // Creating vehicle instances
        Vehicle v1 = new Vehicle("Alice", "Car");
        Vehicle v2 = new Vehicle("Bob", "Motorcycle");

        // Displaying vehicle details
        v1.displayVehicleDetails();
        System.out.println(); // Line break
        v2.displayVehicleDetails();
        System.out.println(); // Line break

        // Updating registration fee
        Vehicle.updateRegistrationFee(120.0);

        // Displaying vehicle details after updating registration fee
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}
