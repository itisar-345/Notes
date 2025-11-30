package foodapp.model;

// ABSTRACT CLASS + Abstraction (Abstract class cannot be instantiated directly, provides common behavior)

public abstract class MenuItem { // 'abstract' keyword prevents instantiation of this class
    private final String id; // 'private' for encapsulation, 'final' to ensure immutability (cannot be changed after initialization)
    protected String name; // 'protected' allows access in subclasses but not from outside package
    public double price; // 'public' allows direct access from anywhere
    private String description; // 'private' to encapsulate to prevent direct access

    // Parameterized Constructor - Initialization of object fields
    public MenuItem(String id, String name, double price) {
        this.id = id; // 'this' keyword refers to current instance
        this.name = name;
        this.price = price;
    }

    // Abstract method - 'abstract' keyword forces implementation in subclasses (Abstraction)
    public abstract String getCategory();

    // Concrete method (can be used as is or overridden) - Polymorphism (Runtime Polymorphism if overridden)
    public String getDetails() {
        return name + " - ₹" + price;
    }

    // Getters (Encapsulation) - 'public' access to private fields via methods
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}