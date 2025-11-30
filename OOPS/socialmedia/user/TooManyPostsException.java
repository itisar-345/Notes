package socialmedia.user;

// CUSTOM EXCEPTION - TooManyPostsException for handling post limit exceedance
// Inheritance - Extends Exception class for custom error handling
public class TooManyPostsException extends Exception {
    public TooManyPostsException(String message) {
        super(message);
    }
}
