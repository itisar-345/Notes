package socialmedia.app;

import socialmedia.post.Post;
import socialmedia.user.User;
import java.util.ArrayList;
import java.util.List;

// SINGLETON CLASS - Only one instance of SocialMediaPlatform exists
// Manages users and posts on the platform

public class SocialMediaPlatform {
    private static final SocialMediaPlatform instance = new SocialMediaPlatform(); // Initialization and Private Static Final because of Singleton Pattern
    private List<User> users = new ArrayList<>(); // Private field - Encapsulation
    private List<Post> allPosts = new ArrayList<>(); // Private field - Encapsulation

    // Private constructor to prevent instantiation
    private SocialMediaPlatform() {
        System.out.println("Social Media Platform is live!");
    }

    // Public method to provide access to the single instance
    public static SocialMediaPlatform getInstance() {
        return instance;
    }

    // Method to register a new user
    public void registerUser(User user) {
        users.add(user);
    }

    // Method to add a post to the platform
    public void addPost(Post post) {
        allPosts.add(post);
    }

    // Getter for users
    // Aggregation - User can exist independently of SocialMediaPlatform
    public List<User> getUsers() { 
        return users; 
    }
}