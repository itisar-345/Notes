package socialmedia.post;

import socialmedia.user.User;

import java.time.LocalDateTime;

// ABSTRACT CLASS + ABSTRACTION

public abstract class Post {
    private Long id; // Encapsulation - private field
    protected String content; // protected access modifier
    public LocalDateTime createdAt; // public access modifier
    private User author; // Composition - Post can't exist without User

    // Default constructor
    public Post() {
        this.createdAt = LocalDateTime.now();
    }

    // Parameterized constructor
    // Constructor Chaining - Calls default constructor to initialize timestamp
    public Post(String content, User author) {
        this(); // Constructor chaining
        this.content = content;
        this.author = author;
    }

    // Abstract method - forces subclasses to implement
    public abstract void display();

    // Concrete method (can be overridden - polymorphism)
    public void like(User user) {
        System.out.println(user.getName() + " liked a post");
    }

    // Getter - Encapsulation
    public User getAuthor() { 
        return author; 
    }
}