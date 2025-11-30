package foodapp;

import foodapp.model.*;
import foodapp.exceptions.*;

// DEMONSTRATION OF THE FOOD DELIVERY APPLICATION

public class FoodDeliveryDemo {
    public static void main(String[] args) { // 'public' access modifier, 'static' class-level method, 'void' return type
        FoodDeliveryApp app = FoodDeliveryApp.getInstance(); // Singleton Instance of FoodDeliveryApp - Creational Pattern

        // Instantiation of Users, Restaurants, and Delivery Partners - Using 'new' keyword for object creation
        User rahul = new User("Rahul", "9876543210", "Mumbai"); // Instantiation of User object
        Restaurant spiceVilla = new Restaurant("Spice Villa", "Andheri"); // Instantiation of Restaurant object
        DeliveryPartner john = new DeliveryPartner("John"); // Instantiation of DeliveryPartner object

        // Initialization of the Application - Registering components
        app.registerRestaurant(spiceVilla);
        app.registerPartner(john);

        // Adding Menu Items to Restaurant - Composition (HAS-A Relationship)
        VegDish paneer = new VegDish("V1", "Paneer Butter Masala", 299); // Instantiation of VegDish object
        VegDish biryani = new VegDish("V2", "Veg Biryani", 199); // Instantiation of VegDish object
        NonVegDish chicken = new NonVegDish("NV1", "Butter Chicken", 399); // Instantiation of NonVegDish object

        // Adding items to Spice Villa's menu - Composition
        spiceVilla.addMenuItem(paneer);
        spiceVilla.addMenuItem(biryani);
        spiceVilla.addMenuItem(chicken);

        // Initiation of an Order - Instantiation of Order object
        Order order = new Order(rahul, spiceVilla); // Instantiation using parameterized constructor
        order.addItem(paneer);
        order.addItem(biryani);

        // Exception Handling - Try-Catch-Finally blocks
        try {
            order.placeOrder(true); // Method call with parameter
            order.processPayment(500); // Method call with parameter

            for (MenuItem item : order.getItems()) { // Enhanced for loop - Iteration over collection
                System.out.println(item.getDetails() + " | Category: " + item.getCategory());
            }

            paneer.addRating(5, "Delicious!"); // Method call

        } catch (RestaurantClosedException | PaymentFailedException e) { // Multi-catch block
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) { // Catch block for general exceptions
            System.out.println("Unexpected error: " + e.getMessage());
        } finally { // Finally block - Always executed
            System.out.println("Order processing finished.\n");
        }

        // Try ordering from closed restaurant - Exception demonstration
        spiceVilla.closeRestaurant(); // Method call
        Order order2 = new Order(rahul, spiceVilla); // Instantiation of another Order object
        order2.addItem(chicken);
        try {
            order2.placeOrder(); // Method call
        } catch (RestaurantClosedException e) { // Catch block for specific exception
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
