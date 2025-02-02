class Product {
    String productName;
    double price;
    static int totalProducts = 0; // Class variable to track total products

    // Constructor
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment total products count
    }

    // Instance method to display product details
    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }

    // Class method to display total number of products created
    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    public static void main(String[] args) {
        // Creating product instances
        Product p1 = new Product("Laptop", 1200.50);
        Product p2 = new Product("Smartphone", 799.99);

        // Displaying product details
        p1.displayProductDetails();
        System.out.println(); // Line break
        p2.displayProductDetails();
        System.out.println(); // Line break

        // Displaying total number of products created
        Product.displayTotalProducts();
    }
}
