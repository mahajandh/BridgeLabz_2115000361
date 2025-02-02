class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    static final double DAILY_RATE = 50.0; // Example daily rental rate

    // Default constructor
    CarRental() {
        this.customerName = "Unknown Customer";
        this.carModel = "Standard Car";
        this.rentalDays = 1;
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Method to calculate total rental cost
    double calculateTotalCost() {
        return rentalDays * DAILY_RATE;
    }

    // Method to display rental details
    void displayDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }

    public static void main(String[] args) {
        // Using default constructor
        CarRental defaultRental = new CarRental();
        defaultRental.displayDetails();

        System.out.println(); // Line break

        // Using parameterized constructor
        CarRental customRental = new CarRental("John Doe", "Toyota Camry", 5);
        customRental.displayDetails();
    }
}
