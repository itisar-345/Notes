package foodapp.exceptions;

// CUSTOM EXCEPTION - Unchecked Exception (extends RuntimeException; not required to be declared or caught, as they represent runtime errors)
// Thrown when a payment transaction fails

public class PaymentFailedException extends RuntimeException { // 'extends' keyword for inheritance from RuntimeException class
    // Constructor that accepts an error message    
    public PaymentFailedException(String message) { 
        super(message); // Pass the message to the parent RuntimeException class
    }
}