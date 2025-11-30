package socialmedia.user;

import socialmedia.post.Post;
import socialmedia.app.SocialMediaPlatform;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name; // private field - Encapsulation
    private String email; // private field - Encapsulation
    protected List<Post> posts = new ArrayList<>(); // Composition - User owns and manages Posts
    private List<User> followers = new ArrayList<>(); // Association - User can follow other Users
    private List<User> following = new ArrayList<>(); // Association - User can be followed by other Users

    // Constructors
    public User() {} // Default constructor

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Copy constructor
    // Constructor Overloading (Polymorphism) - Allows creating a User from another User
    public User(User other) {
        this.name = other.name;
        this.email = other.email;
    }

    // Composition - User can follow another User
    public void follow(User other) {
        this.following.add(other);
        other.followers.add(this); // Bi-directional association
        System.out.println(this.name + " now follows " + other.name);
    }

    // Composition - User can create a Post
    public void createPost(Post post) {
        posts.add(post);
        SocialMediaPlatform.getInstance().addPost(post);
    }

    // Method Overloading (Compile-time Polymorphism)
    public void showFeed() {
        System.out.println(name + "'s feed:");
    }
    public void showFeed(int limit) {
        System.out.println(name + "'s feed (last " + limit + " posts):");
    }

    // Getter for name
    public String getName() { 
        return name; 
    }

    // Getter for posts
    public List<Post> getPosts() { 
        return posts; 
    }
}