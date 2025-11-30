package foodapp.model;

import foodapp.interfaces.Rateable;
import java.util.ArrayList;
import java.util.List;

// INHERITANCE + IMPLEMENTATION OF INTERFACE + SUBCLASS of MenuItem

public class VegDish extends MenuItem implements Rateable { // 'extends' for inheritance, 'implements' for interface implementation
    
    private final List<Integer> ratings = new ArrayList<>(); // 'private' for encapsulation, 'final' to prevent reassignment

    // Parameterized Constructor - Initialization of VegDish object
    public VegDish(String id, String name, double price) {
        super(id, name, price); // 'super' keyword calls superclass constructor
    }

    // Implementing abstract method from MenuItem - Abstraction
    // Polymorphism through Method Overriding (Runtime Polymorphism)
    @Override // '@Override' annotation for method overriding
    public String getCategory() {
        return "Veg";
    }

    // Implementing methods from Rateable interface - Multiple Inheritance via Interfaces
    @Override
    public void addRating(int stars, String review) {
        if (stars < 1 || stars > 5)
            throw new IllegalArgumentException("Rating must be 1-5"); // 'throw' creates and throws an exception object, 'throws' declares that a method may throw exceptions
        ratings.add(stars);
    }

    // Implementing method from Rateable interface
    @Override
    public double getAverageRating() {
        return ratings.isEmpty() ? 0 : ratings.stream()
                .mapToInt(Integer::intValue).average().orElse(0);
    }
}