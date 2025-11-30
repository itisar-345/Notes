package foodapp.model;

// INHERITANCE + ABSTRACT CLASS + SUBCLASS of MenuItem

public class NonVegDish extends MenuItem { // 'extends' keyword for inheritance from abstract class
    
    // Parameterized Constructor - Initialization of NonVegDish object
    public NonVegDish(String id, String name, double price) {
        super(id, name, price); // 'super' keyword calls superclass constructor
    }

    // Implementing abstract method from MenuItem - Abstraction
    // Polymorphism through Method Overriding (Runtime Polymorphism)
    @Override // '@Override' annotation for method overriding
    public String getCategory() {
        return "Non-Veg";
    }
}