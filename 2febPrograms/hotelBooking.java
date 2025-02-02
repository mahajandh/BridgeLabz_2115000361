class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    // Default constructor
    HotelBooking() {
        this.guestName = "Unknown Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }

    // Parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    void displayDetails() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Number of Nights: " + nights);
    }

    public static void main(String[] args) {
        // Using default constructor
        HotelBooking defaultBooking = new HotelBooking();
        defaultBooking.displayDetails();

        System.out.println(); // Line break

        // Using parameterized constructor
        HotelBooking paramBooking = new HotelBooking("John Doe", "Deluxe", 3);
        paramBooking.displayDetails();

        System.out.println(); // Line break

        // Using copy constructor
        HotelBooking copyBooking = new HotelBooking(paramBooking);
        copyBooking.displayDetails();
    }
}

