package socialmedia.post;

import socialmedia.user.User;

// CONCRETE CLASSES with INHERITANCE + POLYMORPHISM
// Inheritance from Post
// Multiple Inheritance via interfaces Likeable
// Polymorphism via method overriding( display, addLike, getLikeCount) = Runtime Polymorphism

public class PhotoPost extends Post implements Likeable {
    private String imageUrl;
    private int likeCount = 0;

    public PhotoPost(String imageUrl, User author) {
        super("Photo Post", author);
        this.imageUrl = imageUrl;
    }

    @Override
    public void display() {
        System.out.println("Photo by " + getAuthor().getName() + " → " + imageUrl);
    }

    @Override
    public void addLike(User user) {
        likeCount += 2; // Double-tap feel
        System.out.println(user.getName() + " double-tapped the photo!");
    }

    @Override
    public int getLikeCount() { return likeCount; }
}