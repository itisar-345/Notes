package foodapp.model;

import foodapp.interfaces.Payable;
import foodapp.exceptions.RestaurantClosedException;
import foodapp.exceptions.PaymentFailedException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// INTERFACE IMPLEMENTATION + METHOD OVERLOADING (COMPILE-TIME POLYMORPHISM)

public class Order implements Payable { // 'implements' keyword for interface implementation
    
    // Private Attributes for encapsulation to prevent direct access from outside - 'private' access modifier
    private final String orderId; // 'final' keyword to ensure immutability (cannot be changed after initialization)
    private User customer;
    private Restaurant restaurant;
    private List<MenuItem> items = new ArrayList<>(); // Aggregation of MenuItems - Instantiation using 'new' keyword
    private double totalAmount;
    private LocalDateTime orderTime;
    private DeliveryPartner deliveryPartner;
    private static int orderCounter = 1000; // 'static' keyword for class-level variable (shared among all instances)

    // Default Constructor - Initialization of Order object
    public Order() {
        this.orderId = "ORD" + (++orderCounter); // 'this' keyword refers to current instance
        this.orderTime = LocalDateTime.now();
    }

    // Parameterized Constructor - Initialization of Order object
    public Order(User customer, Restaurant restaurant) {
        this(); // Constructor Chaining - Call to Default Constructor using 'this'
        this.customer = customer; // 'this' keyword refers to current instance
        this.restaurant = restaurant;
    }

    // Method to add item to the order
    public void addItem(MenuItem item) {
        items.add(item);
        totalAmount += item.price;
    }

    // COMPILE-TIME POLYMORPHISM
    // Method Overloading - placeOrder without priority
    public void placeOrder() throws RestaurantClosedException {
        placeOrder(false);
    }

    // Method Overloading - placeOrder with priority option 
    public void placeOrder(boolean isPriority) throws RestaurantClosedException {
        if (!restaurant.isOpen())
            throw new RestaurantClosedException(restaurant.getName() + " is closed!");

        deliveryPartner = FoodDeliveryApp.getInstance().getAvailablePartner();
        if (deliveryPartner == null)
            System.out.println("No delivery partner available!");

        System.out.println("Order " + orderId + " placed! Total: ₹" + totalAmount);
        if (isPriority) System.out.println("Priority delivery assigned!");
    }

    // Implementing method from Payable interface
    @Override
    public boolean processPayment(double amount) {
        if (amount < totalAmount)
            throw new PaymentFailedException("Insufficient payment!");
        System.out.println("Payment of ₹" + amount + " successful!");
        return true;
    }

    // Getters (Encapsulation)
    public List<MenuItem> getItems() { return items; }
    public String getOrderId() { return orderId; }
}