package foodapp.interfaces;

// INTERFACE + Multiple Inheritance (Interfaces allow multiple inheritance in Java)

public interface Rateable { // 'interface' keyword defines a contract for classes to implement
    void addRating(int stars, String review); // Abstract method - no implementation, must be implemented by implementing classes
    double getAverageRating(); // Abstract method - no implementation, must be implemented by implementing classes
}
