package socialmedia.post;

import socialmedia.user.User;
import java.time.LocalDateTime;

// COMPOSITION/AGGREGATION - Comment is part of posts via Commentable interface
// Represents a comment made by a user on a post

class Comment {
    private String text;
    private User author;
    private LocalDateTime timestamp;

    // Parameterized constructor
    // Getters
    public Comment(String text, User author) {
        this.text = text;
        this.author = author;
        this.timestamp = LocalDateTime.now();
    }

    @Override // Polymorphism - Method Overriding
    public String toString() {
        return author.getName() + ": " + text;
    }
}