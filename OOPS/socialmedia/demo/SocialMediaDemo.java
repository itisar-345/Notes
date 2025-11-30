package socialmedia.demo;

import socialmedia.app.SocialMediaPlatform;
import socialmedia.post.*;
import socialmedia.user.User;
import socialmedia.user.TooManyPostsException;

// DEMONSTRATION CLASS - Showcases the functionality of the Social Media Platform
public class SocialMediaDemo {
    public static void main(String[] args) {
        SocialMediaPlatform platform = SocialMediaPlatform.getInstance();

        User alice = new User("Alice", "alice@social.com");
        User bob = new User("Bob", "bob@social.com");

        platform.registerUser(alice);
        platform.registerUser(bob);

        alice.follow(bob);

        // EXCEPTION HANDLING

        try { // Try block to catch potential exceptions
            Post p1 = new TextPost("My first post!", alice);
            Post p2 = new PhotoPost("vacation.jpg", alice);

            alice.createPost(p1);
            alice.createPost(p2);

            // Runtime Polymorphism in action
            for (Post post : alice.getPosts()) {
                post.display();
                post.like(bob);

                if (post instanceof Likeable likeable) { // Polymorphism - Runtime Type Checking
                    likeable.addLike(bob);
                }
            }

            alice.showFeed();
            alice.showFeed(5); // Overloading

            // Simulate exception
            if (alice.getPosts().size() > 50) {
                throw new TooManyPostsException("Limit exceeded!");
            }

        } catch (TooManyPostsException e) { // Custom Exception Handling
            System.out.println("Warning: " + e.getMessage());
        } catch (Exception e) { // General Exception Handling
            System.out.println("Error: " + e.getMessage());
        } finally { // Finally block
            System.out.println("Session ended.");
        }
    }
}