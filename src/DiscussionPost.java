import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;
/**
 * Project 4 -- Learning Management System
 *
 * This class contains methods for the Discussion Posts
 * that can be created and edited by the users i.e Teachers
 * and Students
 *
 * @author Nandana, Shreyash, Jason, Garv , lab sec L14
 *
 * @version April 9, 2022
 *
 */
public class DiscussionPost implements Comparable<DiscussionPost>, Serializable {

    public final Date repliesSync = new Date(System.currentTimeMillis());
    private ArrayList<DiscussionPost> replies;
    private ArrayList<Vote> votes;
    private String postContent;
    Date postTime;

    public DiscussionPost(String postContent, long postTime) {
        replies = new ArrayList<>();
        this.postContent = postContent;
        this.postTime = new Date(postTime);
        this.votes = new ArrayList<>();
    }

    public DiscussionPost(String postContent, Date postTime) {
        replies = new ArrayList<>();
        this.postContent = postContent;
        this.postTime = postTime;
        this.votes = new ArrayList<>();
    }

    public DiscussionPost(String postContent, long postTime, ArrayList<DiscussionPost> replies) {
        this.replies = replies;
        this.postContent = postContent;
        this.postTime = new Date(postTime);
        this.votes = new ArrayList<>();
    }

    public DiscussionPost(String postContent, Date postTime, ArrayList<DiscussionPost> replies) {
        this.replies = replies;
        this.postContent = postContent;
        this.postTime = postTime;
        this.votes = new ArrayList<>();
    }

    public DiscussionPost() {

    }


    public ArrayList<DiscussionPost> getReplies(boolean isSorted) {
        if (isSorted) Collections.sort(replies);
        return replies;
    }

    public String getPostContent() {
        return postContent;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void addReply(DiscussionPost reply) {
        replies.add(reply);
    }

    public void deleteReply(DiscussionPost deletingReply) throws NoPermissionException, NoSuchTargetException {
        if (Teacher.class == UserActivities.currentUser.getClass()) {
            if (!replies.remove(deletingReply)) throw new NoSuchTargetException();
        } else {
            throw new NoPermissionException();
        }
    }

    public void addVote(Vote vote) {
        votes.add(vote);
    }

    public int getVotes() {
        return votes.size();
    }

    @Override
    public int compareTo(DiscussionPost o) {
        Integer voteNum = getVotes();
        Integer anotherVoteNum = o.getVotes();
        return voteNum.compareTo(anotherVoteNum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscussionPost post = (DiscussionPost) o;
        return Objects.equals(replies, post.replies) && Objects.equals(postContent, post.postContent) && Objects.equals(postTime, post.postTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(replies, postContent, postTime);
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Post Time: ").append(postTime).append('\n');
        sb.append("Content: ").append(postContent);

        if (votes.size() != 0) {
            sb.append('\n').append("Votes: ").append(getVotes());
        }

        if (replies.size() != 0) {
            sb.append('\n').append("Replies: ");
            for (int i = 0; i < replies.size(); i++) {
                sb.append('\n').append(i + 1).append(". \n").append(replies.get(i));
            }
        }

        return sb.toString();

    }
}
