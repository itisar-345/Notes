package foodapp.model;

import java.util.ArrayList;
import java.util.List;

// COMPOSITION (HAS-A Relationship) + ASSOCIATION (USES-A Relationship)

public class Restaurant {

    // Private Attributes for encapsulation to prevent direct access - 'private' access modifier
    private String name; // Restaurant HAS-A name
    private String address; // Restaurant HAS-A address
    private boolean isOpen = true; // Restaurant HAS-A isOpen status - Default initialization
    private List<MenuItem> menu = new ArrayList<>(); // Restaurant HAS-A Menu (Composition) - Instantiation using 'new' keyword
    private List<Order> activeOrders = new ArrayList<>(); // Restaurant USES-A Orders (Association) - Instantiation using 'new' keyword

    // Parameterized Constructor - Initialization of Restaurant object
    public Restaurant(String name, String address) {
        this.name = name; // 'this' keyword refers to current instance
        this.address = address;
    }

    // Methods to manage menu and orders
    public void addMenuItem(MenuItem item) { menu.add(item); }
    public List<MenuItem> getMenu() { return menu; }
    public boolean isOpen() { return isOpen; }
    public void closeRestaurant() { isOpen = false; }
    public String getName() { return name; }
}