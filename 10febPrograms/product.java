import java.util.*;

// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();
}

// Interface Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics class
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.15;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: 15%";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.2;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: 5%";
    }
}

// Groceries class
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

// Main class
public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        
        Product p1 = new Electronics(101, "Laptop", 1000);
        Product p2 = new Clothing(102, "T-Shirt", 50);
        Product p3 = new Groceries(103, "Apples", 10);
        
        products.add(p1);
        products.add(p2);
        products.add(p3);
        
        for (Product product : products) {
            double finalPrice = product.getPrice() - product.calculateDiscount();
            if (product instanceof Taxable) {
                finalPrice += ((Taxable) product).calculateTax();
                System.out.println(product.getName() + " - Final Price: " + finalPrice + ", " + ((Taxable) product).getTaxDetails());
            } else {
                System.out.println(product.getName() + " - Final Price: " + finalPrice);
            }
        }
    }
}

