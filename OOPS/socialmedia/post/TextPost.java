package socialmedia.post;

import socialmedia.user.User;
import java.util.ArrayList;
import java.util.List;

// CONCRETE CLASSES with INHERITANCE + POLYMORPHISM

// Inheritance from Post
// Multiple Inheritance via interfaces Likeable and Commentable
// Polymorphism via method overriding ( display, addLike, getLikeCount, addComment, getComments) = Runtime Polymorphism

public class TextPost extends Post implements Likeable, Commentable {
    private int likeCount = 0;
    private List<Comment> comments = new ArrayList<>();

    public TextPost(String content, User author) {
        super(content, author); // Constructor chaining to parent
    }

    @Override
    public void display() {
        System.out.println("Text Post by " + getAuthor().getName() + ": " + content);
    }

    @Override
    public void addLike(User user) {
        likeCount++;
        System.out.println(user.getName() + " liked the text post");
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