import java.util.ArrayList;
import java.util.List;

// Abstract Product class with a generic category
abstract class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
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

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - Name: " + name + ", Price: $" + price + ", Category: " + category;
    }
}

// Enum Categories
enum BookCategory { FICTION, NON_FICTION, SCIENCE }
enum ClothingCategory { MENS, WOMENS, KIDS }
enum GadgetCategory { SMARTPHONE, LAPTOP, ACCESSORY }

// Concrete Product Classes
class Book extends Product<BookCategory> {
    public Book(String name, double price, BookCategory category) {
        super(name, price, category);
    }
}

class Clothing extends Product<ClothingCategory> {
    public Clothing(String name, double price, ClothingCategory category) {
        super(name, price, category);
    }
}

class Gadget extends Product<GadgetCategory> {
    public Gadget(String name, double price, GadgetCategory category) {
        super(name, price, category);
    }
}

// Generic Product Catalog
class ProductCatalog<T extends Product<?>> {
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public List<T> getProducts() {
        return products;
    }
}

// Utility class with a generic discount method
class DiscountManager {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discountedPrice);
        System.out.println("Discount applied! New Price of " + product.getName() + ": $" + discountedPrice);
    }
}

// Main Class
public class OnlineMarketplace {
    public static void main(String[] args) {
        // Create product catalogs
        ProductCatalog<Book> bookCatalog = new ProductCatalog<>();
        ProductCatalog<Clothing> clothingCatalog = new ProductCatalog<>();
        ProductCatalog<Gadget> gadgetCatalog = new ProductCatalog<>();

        // Add products
        Book book = new Book("Java Programming", 50.00, BookCategory.SCIENCE);
        Clothing clothing = new Clothing("T-Shirt", 20.00, ClothingCategory.MENS);
        Gadget gadget = new Gadget("Smartphone", 700.00, GadgetCategory.SMARTPHONE);

        bookCatalog.addProduct(book);
        clothingCatalog.addProduct(clothing);
        gadgetCatalog.addProduct(gadget);

        // Apply discounts
        DiscountManager.applyDiscount(book, 10);
        DiscountManager.applyDiscount(clothing, 5);
        DiscountManager.applyDiscount(gadget, 15);

        // Display products
        System.out.println("\nBook Catalog:");
        bookCatalog.getProducts().forEach(System.out::println);

        System.out.println("\nClothing Catalog:");
        clothingCatalog.getProducts().forEach(System.out::println);

        System.out.println("\nGadget Catalog:");
        gadgetCatalog.getProducts().forEach(System.out::println);
    }
}
