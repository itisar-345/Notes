package foodapp.interfaces;

// INTERFACE + Multiple Inheritance (Interfaces allow multiple inheritance in Java)

public interface Payable { // 'interface' keyword defines a contract for classes to implement
    boolean processPayment(double amount); // Abstract method - no implementation, must be implemented by implementing classes
}
