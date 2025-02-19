import java.util.*;

class ShoppingCart {
    private Map<String, Double> priceMap = new HashMap<>();
    private Map<String, Double> orderedCart = new LinkedHashMap<>();
    private Map<String, Double> sortedCart = new TreeMap<>(Comparator.comparingDouble(priceMap::get));

    public void addProduct(String product, double price) {
        priceMap.put(product, price);
        orderedCart.put(product, price);
        sortedCart.put(product, price);
    }

    public void displayCart() {
        System.out.println("Cart in insertion order: " + orderedCart);
        System.out.println("Cart sorted by price: " + sortedCart);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Apple", 1.99);
        cart.addProduct("Banana", 0.99);
        cart.addProduct("Cherry", 2.49);
        cart.addProduct("Date", 3.99);
        
        cart.displayCart();
    }
}
