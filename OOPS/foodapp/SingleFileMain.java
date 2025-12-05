package foodapp;

import java.time.LocalDateTime;
import java.util.*;

// 1. CUSTOM EXCEPTION (Checked + Unchecked)
class RestaurantClosedException extends Exception {
    public RestaurantClosedException(String msg) { super(msg); }
}
class PaymentFailedException extends RuntimeException {
    public PaymentFailedException(String msg) { super(msg); }
}

// 2. INTERFACE + Multiple Inheritance
interface Payable {
    boolean processPayment(double amount);
}

interface Rateable {
    void addRating(int stars, String review);
    double getAverageRating();
}

// 3. ABSTRACT CLASS + ABSTRACTION
abstract class MenuItem {
    private final String id;                    // final keyword
    protected String name;                      // protected
    public double price;                        // public
    private String description;                 // private

    // Parameterized constructor
    public MenuItem(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Abstract method - forces implementation
    abstract String getCategory();

    // Concrete method (can be overridden)
    public String getDetails() {
        return name + " - ₹" + price;
    }

    // Getters (Encapsulation)
    public String getId() { return id; }
    public String getName() { return name; }
}

// 4. INHERITANCE + POLYMORPHISM
class VegDish extends MenuItem implements Rateable {
    private final List<Integer> ratings = new ArrayList<>();

    public VegDish(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    String getCategory() { return "Veg"; }

    @Override
    public void addRating(int stars, String review) {
        if (stars < 1 || stars > 5) throw new IllegalArgumentException("Rating 1-5 only");
        ratings.add(stars);
    }

    @Override
    public double getAverageRating() {
        return ratings.isEmpty() ? 0 : ratings.stream().mapToInt(Integer::intValue).average().orElse(0);
    }
}

class NonVegDish extends MenuItem {
    public NonVegDish(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    String getCategory() { return "Non-Veg"; }
}

// 5. COMPOSITION (Strong ownership) + ASSOCIATION
class Restaurant {
    private String name;
    private String address;
    private boolean isOpen;
    private List<MenuItem> menu = new ArrayList<>();        // Composition
    private List<Order> activeOrders = new ArrayList<>();   // Association

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.isOpen = true;
    }

    public void addMenuItem(MenuItem item) { menu.add(item); }
    public List<MenuItem> getMenu() { return menu; }
    public boolean isOpen() { return isOpen; }
    public void closeRestaurant() { isOpen = false; }

    public String getName() { return name; }
}

// 6. AGGREGATION (Weak relationship)
class DeliveryPartner {
    private String name;
    private boolean isAvailable = true;
    private List<Order> assignedOrders = new ArrayList<>();  // Aggregation

    public DeliveryPartner(String name) { this.name = name; }

    public boolean isAvailable() { return isAvailable; }
    public void assignOrder(Order order) {
        assignedOrders.add(order);
        isAvailable = false;
    }
    public String getName() { return name; }
}

// 7. SINGLETON - Only one Food Delivery App Platform
class FoodDeliveryApp {
    private static final FoodDeliveryApp instance = new FoodDeliveryApp();

    private List<Restaurant> restaurants = new ArrayList<>();
    private List<DeliveryPartner> partners = new ArrayList<>();
    private List<Order> allOrders = new ArrayList<>();

    private FoodDeliveryApp() {
        System.out.println("FoodDeliveryApp Platform Launched!");
    }

    public static FoodDeliveryApp getInstance() {
        return instance;
    }

    public void registerRestaurant(Restaurant r) { restaurants.add(r); }
    public void registerPartner(DeliveryPartner p) { partners.add(p); }
    public List<Restaurant> getRestaurants() { return restaurants; }
    public DeliveryPartner getAvailablePartner() {
        return partners.stream().filter(DeliveryPartner::isAvailable).findFirst().orElse(null);
    }
    public void addOrder(Order order) { allOrders.add(order); }
}

// 8. MAIN ORDER CLASS - Uses everything
class Order implements Payable {
    private final String orderId;
    private User customer;
    private Restaurant restaurant;
    private List<MenuItem> items = new ArrayList<>();
    private double totalAmount;
    private LocalDateTime orderTime;
    private DeliveryPartner deliveryPartner;
    private static int orderCounter = 1000;  // static keyword

    // All types of constructors
    public Order() { 
        this.orderId = "ORD" + (++orderCounter);
        this.orderTime = LocalDateTime.now();
    }

    public Order(User customer, Restaurant restaurant) {
        this();  // Constructor chaining
        this.customer = customer;
        this.restaurant = restaurant;
    }

    public void addItem(MenuItem item) {
        items.add(item);
        totalAmount += item.price;
    }

    // Method Overloading - Compile-time Polymorphism
    public void placeOrder() throws RestaurantClosedException {
        placeOrder(false);
    }

    public void placeOrder(boolean isPriority) throws RestaurantClosedException {
        if (!restaurant.isOpen())
            throw new RestaurantClosedException(restaurant.getName() + " is closed!");

        deliveryPartner = FoodDeliveryApp.getInstance().getAvailablePartner();
        if (deliveryPartner == null)
            System.out.println("No delivery partner available!");

        System.out.println("Order " + orderId + " placed! Total: ₹" + totalAmount);
        if (isPriority) System.out.println("Priority delivery assigned!");
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount < totalAmount) {
            throw new PaymentFailedException("Insufficient payment!");
        }
        System.out.println("Payment of ₹" + amount + " successful!");
        return true;
    }

    public String getOrderId() { return orderId; }
}

// 9. USER CLASS
class User {
    private String name;
    private String phone;
    private String address;
    private List<Order> orderHistory = new ArrayList<>();  // Composition

    public User(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void placeOrder(Order order) {
        orderHistory.add(order);
        FoodDeliveryApp.getInstance().addOrder(order);
    }

    public String getName() { return name; }
}

// 10. MAIN DEMO - Shows Runtime Polymorphism + Exception Handling
public class FoodDeliveryDemo {
    public static void main(String[] args) {
        FoodDeliveryApp app = FoodDeliveryApp.getInstance();

        // Create objects
        User rahul = new User("Rahul", "9876543210", "Mumbai");
        Restaurant spiceVilla = new Restaurant("Spice Villa", "Andheri");
        DeliveryPartner john = new DeliveryPartner("John");

        app.registerRestaurant(spiceVilla);
        app.registerPartner(john);

        // Add menu items
        VegDish paneer = new VegDish("V1", "Paneer Butter Masala", 299);
        VegDish biryani = new VegDish("V2", "Veg Biryani", 199);
        NonVegDish chicken = new NonVegDish("NV1", "Butter Chicken", 399);

        spiceVilla.addMenuItem(paneer);
        spiceVilla.addMenuItem(biryani);
        spiceVilla.addMenuItem(chicken);

        // Create and place order
        Order order = new Order(rahul, spiceVilla);
        order.addItem(paneer);
        order.addItem(biryani);

        try {
            order.placeOrder(true);        // Overloaded method
            order.processPayment(500);

            // Runtime Polymorphism
            for (MenuItem item : order.items) {
                System.out.println(item.getDetails() + " | Category: " + item.getCategory());
            }

            paneer.addRating(5, "Amazing!");

        } catch (RestaurantClosedException e) {
            System.out.println("Order failed: " + e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println("Payment Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            System.out.println("Order processing completed.\n");
        }

        // Close restaurant and try ordering
        spiceVilla.closeRestaurant();
        Order order2 = new Order(rahul, spiceVilla);
        order2.addItem(chicken);

        try {
            order2.placeOrder();
        } catch (RestaurantClosedException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}