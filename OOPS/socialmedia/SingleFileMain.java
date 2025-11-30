// SINGLE FILE DEMONSTRATION OF OOP CONCEPTS IN A SOCIAL MEDIA CONTEXT

import java.util.ArrayList;

// 1. ABSTRACT CLASS + ABSTRACTION
abstract class Post {
    private Long id;                   // Encapsulation - private field
    protected String content;          // protected access modifier
    public LocalDateTime createdAt;    // public access modifier
    private User author;               // Composition - Post can't exist without User

    // Default constructor
    public Post() {
        this.createdAt = LocalDateTime.now();
    }

    // Parameterized constructor
    public Post(String content, User author) {
        this(); // Constructor chaining
        this.content = content;
        this.author = author;
    }

    // Abstract method - forces subclasses to implement
    abstract void displayPost();

    // Concrete method (can be overridden - polymorphism)
    public void like(User user) {
        System.out.println(user.getName() + " liked the post.");
    }

    // Getter - Encapsulation
    public User getAuthor() {
        return author;
    }
}

// 2. INTERFACE + Multiple Inheritance via interfaces
interface Likable {
    void addLike(User user);
    int getLikeCount();
}

interface Commentable {
    void addComment(Comment comment);
    List<Comment> getComments();
}

// 3. CONCRETE CLASSES with INHERITANCE + POLYMORPHISM

// Text Post (Inheritance)
class TextPost extends Post implements Likable, Commentable {
    private int likeCount = 0;
    private List<Comment> comments = new ArrayList<>();

    // Constructor chaining
    public TextPost(String content, User author) {
        super(content, author);  // Constructor chaining to parent
    }

    @Override
    void displayPost() {
        System.out.println("Text: " + content + " by " + getAuthor().getName());
    }

    @Override
    public void addLike(User user) {
        likeCount++;
    }

    @Override
    public int getLikeCount() { return likeCount; }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() { return comments; }
}

// Photo Post - Same parent, different behavior = Runtime Polymorphism
class PhotoPost extends Post implements Likable {
    private String imageUrl;
    private int likeCount = 0;

    public PhotoPost(String imageUrl, User author) {
        super("Photo post", author);
        this.imageUrl = imageUrl;
    }

    @Override
    void displayPost() {
        System.out.println("Photo by " + getAuthor().getName() + ": " + imageUrl);
    }

    @Override
    public void addLike(User user) {
        likeCount++;
        System.out.println("Double-tap like on photo!");
    }

    @Override
    public int getLikeCount() { return likeCount; }
}

// 4. COMPOSITION vs AGGREGATION
class Comment {
    private String text;
    private User author;
    private LocalDateTime timestamp;

    public Comment(String text, User author) {
        this.text = text;
        this.author = author;
        this.timestamp = LocalDateTime.now();
    }
    // getters...
}

// 5. SINGLETON CLASS - Only one social media platform instance
class SocialMediaPlatform {
    private static SocialMediaPlatform instance = new SocialMediaPlatform();
    private List<User> users = new ArrayList<>();
    private List<Post> allPosts = new ArrayList<>();

    // Private constructor - Singleton
    private SocialMediaPlatform() {
        System.out.println("Social Media Platform Started!");
    }

    public static SocialMediaPlatform getInstance() {
        return instance;
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public void addPost(Post post) {
        allPosts.add(post);
    }

    // Aggregation - Users exist independently of platform
    public List<User> getUsers() { return users; }
}

// 6. MAIN USER CLASS - Association, Aggregation
class User {
    private String name;                    // private - encapsulation
    private String email;
    protected List<Post> posts = new ArrayList<>();    // User owns posts (Composition)
    private List<User> followers = new ArrayList<>();  // Association
    private List<User> following = new ArrayList<>();

    // All types of constructors
    public User() {} // default

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Copy constructor
    public User(User other) {
        this.name = other.name;
        this.email = other.email;
    }

    public void follow(User other) {
        this.following.add(other);
        other.followers.add(this);  // bidirectional association
        System.out.println(this.name + " followed " + other.name);
    }

    public void createPost(Post post) {
        posts.add(post);
        SocialMediaPlatform.getInstance().addPost(post);
    }

    public String getName() { return name; }

    // Method Overloading = Compile-time Polymorphism
    public void displayFeed() {
        System.out.println(name + "'s feed:");
    }

    public void displayFeed(int limit) {
        System.out.println(name + "'s feed (last " + limit + " posts):");
    }
}

// 7. ALL TYPES OF EXCEPTION HANDLING
class SocialMediaDemo {
    public static void main(String[] args) {
        SocialMediaPlatform platform = SocialMediaPlatform.getInstance(); // Singleton

        User alice = new User("Alice", "alice@example.com");
        User bob = new User("Bob", "bob@example.com");

        platform.registerUser(alice);
        platform.registerUser(bob);

        alice.follow(bob);

        try {
            Post post1 = new TextPost("Hello World!", alice);
            Post post2 = new PhotoPost("sunset.jpg", alice);

            alice.createPost(post1);
            alice.createPost(post2);

            // Runtime Polymorphism - same method call, different behavior
            for (Post p : platform.getUsers().get(0).posts) {
                p.displayPost();   // Calls TextPost or PhotoPost version
                p.like(bob);

                if (p instanceof Likable) {
                    ((Likable) p).addLike(bob);
                }
            }

            // Custom Exception Example
            if (alice.posts.size() > 100) {
                throw new TooManyPostsException("User exceeded post limit!");
            }

        } catch (TooManyPostsException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        } catch (Exception e) {  // General exception
            System.out.println("Something went wrong: " + e.getMessage());
        } finally {
            System.out.println("Cleanup done.");
        }
    }
}

// 8. CUSTOM EXCEPTION
class TooManyPostsException extends Exception {
    public TooManyPostsException(String message) {
        super(message);
    }
}