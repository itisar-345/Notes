package foodapp.exceptions;

// CUSTOM EXCEPTION - Checked Exception (Must be caught with 'try-catch' or declare them in the method signature with 'throws')

public class RestaurantClosedException extends Exception { // 'extends' keyword for inheritance from Exception class
    public RestaurantClosedException(String message) {
        super(message); // 'super' keyword calls superclass constructor
    }
}
