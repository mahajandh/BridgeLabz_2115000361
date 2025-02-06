import java.util.ArrayList;

// Product class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Order class
class Order {
    private ArrayList<Product> products;

    public Order() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayOrder() {
        System.out.println("Order contains:");
        for (Product product : products) {
            System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
        }
    }
}

// Customer class
class Customer {
    private String name;
    private ArrayList<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void displayOrders() {
        System.out.println("Customer: " + name + " - Orders:");
        for (Order order : orders) {
            order.displayOrder();
        }
    }
}

// E-commerce platform simulation
public class ECommercePlatform {
    public static void main(String[] args) {
        // Create customers
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        // Create products
        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Smartphone", 800.00);
        Product product3 = new Product("Headphones", 150.00);

        // Create orders
        Order order1 = new Order();
        order1.addProduct(product1);
        order1.addProduct(product2);

        Order order2 = new Order();
        order2.addProduct(product3);

        // Customers place orders
        customer1.placeOrder(order1);
        customer2.placeOrder(order2);

        // Display customer orders
        customer1.displayOrders();
        customer2.displayOrders();
    }
}