import java.util.*;

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }

    public abstract double calculateTotalPrice();
}

// Interface Discountable
interface Discountable {
    double applyDiscount(double discountPercentage);
    String getDiscountDetails();
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount(double discountPercentage) {
        return calculateTotalPrice() * (1 - discountPercentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Veg items eligible for a discount.";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private static final double EXTRA_CHARGE = 1.1; // 10% additional charge

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() * EXTRA_CHARGE;
    }

    @Override
    public double applyDiscount(double discountPercentage) {
        return calculateTotalPrice() * (1 - discountPercentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Non-veg items have an additional 10% charge but are eligible for discounts.";
    }
}

// Main class
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        
        FoodItem item1 = new VegItem("Paneer Butter Masala", 200, 2);
        FoodItem item2 = new NonVegItem("Chicken Biryani", 300, 1);
        
        order.add(item1);
        order.add(item2);
        
        for (FoodItem item : order) {
            System.out.println(item.getItemDetails() + " | Total Price: " + item.calculateTotalPrice());
            
            if (item instanceof Discountable) {
                System.out.println(((Discountable) item).getDiscountDetails() + ", Price after Discount: " + ((Discountable) item).applyDiscount(10));
            }
        }
    }
}
