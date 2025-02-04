
class Vehicle {
    private static double registrationFee = 500.0;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner: " + this.ownerName);
            System.out.println("Vehicle Type: " + this.vehicleType);
            System.out.println("Registration Number: " + this.registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        } else {
            System.out.println("Invalid vehicle instance.");
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("John Doe", "Car", "ABC1234");
        Vehicle vehicle2 = new Vehicle("Jane Smith", "Motorcycle", "XYZ5678");

        updateRegistrationFee(550.0);
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}

