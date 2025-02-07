class Order {
    int orderId;
    String orderDate;

    // Constructor
    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Method to get the order status
    String getOrderStatus() {
        return "Order placed on " + orderDate;
    }
}

// Subclass: ShippedOrder
class ShippedOrder extends Order {
    String trackingNumber;

    // Constructor
    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);  // Calling Order constructor
        this.trackingNumber = trackingNumber;
    }

    // Overriding getOrderStatus to reflect shipping status
    @Override
    String getOrderStatus() {
        return "Order shipped on " + orderDate + " with tracking number: " + trackingNumber;
    }
}

// Subclass: DeliveredOrder
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    // Constructor
    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);  // Calling ShippedOrder constructor
        this.deliveryDate = deliveryDate;
    }

    // Overriding getOrderStatus to reflect delivery status
    @Override
    String getOrderStatus() {
        return "Order delivered on " + deliveryDate + " (shipped on " + orderDate + " with tracking number: " + trackingNumber + ")";
    }
}

// Main Class to test Online Retail Order Management
public class OrderManagementSystem {
    public static void main(String[] args) {
        // Creating objects for different order stages
        Order order = new Order(101, "2025-02-01");
        ShippedOrder shippedOrder = new ShippedOrder(102, "2025-02-02", "T12345");
        DeliveredOrder deliveredOrder = new DeliveredOrder(103, "2025-02-03", "T67890", "2025-02-05");

        // Displaying order status for each order stage
        System.out.println("Order Status: " + order.getOrderStatus());
        System.out.println("Shipped Order Status: " + shippedOrder.getOrderStatus());
        System.out.println("Delivered Order Status: " + deliveredOrder.getOrderStatus());
    }
}