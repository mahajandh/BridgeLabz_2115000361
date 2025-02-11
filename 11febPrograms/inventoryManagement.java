class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head;

    // Add an item at the beginning
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Remove an item by Item ID
    public void removeItem(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) temp.next = temp.next.next;
    }

    // Update quantity of an item by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    // Search for an item by Item ID
    public Item searchById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search for an item by Item Name
    public Item searchByName(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Calculate total inventory value
    public double calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        return total;
    }

    // Display inventory items
    public void displayInventory() {
        Item temp = head;
        while (temp != null) {
            System.out.println("Item: " + temp.itemName + ", ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItemAtEnd("Laptop", 101, 10, 500.0);
        inventory.addItemAtBeginning("Mouse", 102, 50, 20.0);
        
        System.out.println("\nInventory Items:");
        inventory.displayInventory();
        
        System.out.println("\nTotal Inventory Value: " + inventory.calculateTotalValue());
        
        inventory.updateQuantity(101, 15);
        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();
    }
}
