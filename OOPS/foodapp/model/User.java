package foodapp.model;

import java.util.ArrayList;
import java.util.List;

// COMPOSITION (HAS-A Relationship) + ENCAPSULATION
public class User {

    // Private Attributes for encapsulation to prevent direct access from outside
    private String name; // 'private' access modifier for encapsulation
    private String phone;
    private String address;
    private List<Order> orderHistory = new ArrayList<>(); // Composition - User HAS-A Order History

    // Parameterized Constructor - Initialization of User object
    public User(String name, String phone, String address) {
        this.name = name; // 'this' keyword refers to current instance
        this.phone = phone;
        this.address = address;
    }

    // Method to place an order - Association (USES-A Relationship)
    public void placeOrder(Order order) {
        orderHistory.add(order);
        FoodDeliveryApp.getInstance().addOrder(order); // Association - User USES-A FoodDeliveryApp (Singleton)
    }

    // Getters (Encapsulation) - 'public' methods to access 'private' fields
    public String getName() { return name; }
}