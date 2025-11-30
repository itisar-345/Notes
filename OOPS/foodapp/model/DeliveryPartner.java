package foodapp.model;

import java.util.ArrayList;
import java.util.List;

// AGGREGATION (HAS-A Relationship)

public class DeliveryPartner {

    // Private Attributes for encapsulation to prevent direct access - 'private' access modifier
    private String name; // DeliveryPartner HAS-A name
    private boolean isAvailable = true; // DeliveryPartner HAS-A availability status - Default initialization
    private List<Order> assignedOrders = new ArrayList<>(); // Aggregation of Orders - Instantiation using 'new' keyword

    // Parameterized Constructor - Initialization of DeliveryPartner object
    public DeliveryPartner(String name) {
        this.name = name; // 'this' keyword refers to current instance
    }

    // Getter (Encapsulation) - 'public' method to access 'private' field
    public boolean isAvailable() {
        return isAvailable;
    }

    // Method to assign order to delivery partner - Association
    public void assignOrder(Order order) {
        assignedOrders.add(order);
        isAvailable = false;
    }

    // Getter (Encapsulation) - 'public' method to access 'private' field
    public String getName() {
        return name;
    }
}