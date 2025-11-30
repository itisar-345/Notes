package socialmedia.post;

import java.util.List;

// INTERFACE + Multiple Inheritance via interfaces
// Commentable interface for adding and retrieving comments
// Abstraction - Defines contract for comment management without implementation
// Multiple Inheritance - Allows classes to implement multiple interfaces

interface Commentable {
    void addComment(Comment comment);
    List<Comment> getComments();
}