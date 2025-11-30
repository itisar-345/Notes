package foodapp.model;

import java.util.ArrayList;
import java.util.List;

// SINGLETON PATTERN - Only one FoodDeliveryApp (Creational Design Pattern)

public class FoodDeliveryApp {
    private static final FoodDeliveryApp instance = new FoodDeliveryApp(); // 'static' class-level variable, 'final' for immutability - Initializing the single instance

    // Private Attributes to prevent direct access - Encapsulation
    private List<Restaurant> restaurants = new ArrayList<>();
    private List<DeliveryPartner> partners = new ArrayList<>();
    private List<Order> allOrders = new ArrayList<>();

    // Private Constructor to prevent instantiation from outside - Singleton
    private FoodDeliveryApp() {
        System.out.println("FoodDeliveryApp Platform Launched!");
    }

    // Public method to provide access to the single instance - 'static' method
    public static FoodDeliveryApp getInstance() {
        return instance;
    }

    // Methods to manage restaurants, partners, and orders - Association
    public void registerRestaurant(Restaurant r) { restaurants.add(r); }
    public void registerPartner(DeliveryPartner p) { partners.add(p); }

    // Getter for restaurants - Encapsulation
    public List<Restaurant> getRestaurants() { return restaurants; }

    // Method to get an available delivery partner - Association
    public DeliveryPartner getAvailablePartner() {
        return partners.stream() // Stream through partners
                .filter(DeliveryPartner::isAvailable) // Check availability
                .findFirst().orElse(null); // Return null if none available
    }

    // Method to add order to all orders list - Association
    public void addOrder(Order order) { allOrders.add(order); }
}