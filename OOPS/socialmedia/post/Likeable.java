package socialmedia.post;

import socialmedia.user.User;

// INTERFACE + Multiple Inheritance via interfaces
// Abstraction - Defines contract for like functionality without implementation
// Multiple Inheritance - Allows classes to implement multiple interfaces
public interface Likeable {
    void addLike(User user);
    int getLikeCount();
}
