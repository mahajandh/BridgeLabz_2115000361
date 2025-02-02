class Circle {
    double radius;

    // Default constructor
    Circle() {
        this(1.0); // Calls the parameterized constructor with a default value
    }

    // Parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }

    public static void main(String[] args) {
        // Using default constructor
        Circle defaultCircle = new Circle();
        defaultCircle.displayDetails();

        System.out.println(); // Line break

        // Using parameterized constructor
        Circle customCircle = new Circle(5.0);
        customCircle.displayDetails();
    }
}
