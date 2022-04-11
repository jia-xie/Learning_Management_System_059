import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

/**
 * Project 4 -- Learning Management System
 *
 * This class contains methods for the Discussion Forum
 * that can be created and edited by the users i.e Teachers
 * and Students
 *
 * @author Kundana, Shreyash, Jia Xie, Garv , lab sec L14
 *
 * @version April 9, 2022
 *
 */
public class DiscussionForum implements Serializable {

    private String topic;
    ArrayList<DiscussionPost> posts;
    public final Date postsSync = new Date(System.currentTimeMillis());

    public DiscussionForum() {}

    public DiscussionForum(String topic, ArrayList<DiscussionPost> posts) {
        this.topic = topic;
        this.posts = posts;
    }

    public DiscussionForum(String topic) {
        this.topic = topic;
        this.posts = new ArrayList<>();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void displayContentList() {
        for (int i = 0; i < posts.size(); i++) {
            DiscussionPost post = posts.get(i);
            System.out.println((i + 1) + ". " + post.getPostContent());
            if (i != posts.size() - 1) System.out.println();
        }
    }

    public ArrayList<DiscussionPost> getPosts() {
        Collections.sort(posts);
        return posts;

    }
    public int getPostsNum() {
        return posts.size();
    }
    public void addPost(DiscussionPost post) {
        posts.add(post);
    }

    public void deletePost(DiscussionPost post){
        posts.remove(post);
    }

    public boolean isUserVoted(User user) {
        for (DiscussionPost post: posts) {
            ArrayList<Vote> votes = post.getVotes();
            for (Vote vote : votes) {
                if (vote.getStudent().equals(user)) return true;
            }
        }
        return false;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Topic: ").append(topic);
        if (posts.size() != 0) {
            for (int i = 0; i < posts.size(); i++) {
                sb.append("\nPost ").append(i +1).append(". \n").append(posts.get(i));
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscussionForum forum = (DiscussionForum) o;
        return Objects.equals(topic, forum.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic);
    }
}
