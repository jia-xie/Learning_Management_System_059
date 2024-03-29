package util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Project 5 -- Learning Management System
 * <p>
 *
 * A class that represents a packet.
 * ************************************
 * requestType: an integer that tells the server which kind of request is this.
 * msg: a String array that helps to communicate
 * posts: a List of String that helps the client to display the posts
 * replies: a List of String that helps the client to display the replies
 * isOperationSuccess: a boolean that illustrates if the action succeed
 * ************************************
 *
 * <p>Purdue University -- CS18000 -- Spring 2022</p>
 *
 * @author Nandana, Shreyash, Jason, Garv , lab sec L14
 *
 * @version May 2nd, 2022
 */

public class Packet implements Serializable {

    private int requestType;
    private String[] msg;
    private List<String[]> posts;
    private List<String[]> replies;
    private Date date;
    private boolean operationSuccess;


    public static final int LOGIN = 0;
    public static final int CREATE_ACCOUNT = 1;
    public static final int DELETE_ACCOUNT = 2;
    public static final int LOGOUT = 3;

    public static final int CREATE_COURSE = 10;
    public static final int RENAME_COURSE = 11;
    public static final int DELETE_COURSE = 12;
    public static final int ENTER_COURSE = 13;

    public static final int CREATE_FORUM = 20;
    public static final int EDIT_TOPIC = 21;
    public static final int DELETE_FORUM = 22;
    public static final int ENTER_FORUM = 23;

    public static final int CREATE_POST = 30;
    public static final int DELETE_POST = 31;
    public static final int EDIT_POST = 32;
    public static final int REPLY_POST = 33;
    public static final int VOTE_POST = 34;

    public static final int REQUEST_COURSE_TITLES = 40;
    public static final int REQUEST_FORUM_TOPICS = 41;
    public static final int REQUEST_POST_LIST = 42;
    public static final int REQUEST_POST_LIST_BY_VOTE = 43;

    public Packet(int requestType) {
        this.requestType = requestType;
    }

    public Packet(List<String[]> posts, List<String[]> replies, boolean operationSuccess) {
        this.posts = posts;
        this.replies = replies;
        this.operationSuccess = operationSuccess;
    }

    public Packet(int requestType, String[] msg, Date date) {
        this.requestType = requestType;
        this.msg = msg;
        this.date = date;
    }

    public Packet(int requestType, String[] msg) {
        this.requestType = requestType;
        this.msg = msg;
    }

    public Packet(int requestType, String[] msg, boolean operationSuccess) {
        this.requestType = requestType;
        this.msg = msg;
        this.operationSuccess = operationSuccess;
    }

    public Packet(boolean operationSuccess) {
        this.operationSuccess = operationSuccess;
    }

    public Packet(String[] msg) {
        this.msg = msg;
    }

    public Packet(String[] msg, boolean operationSuccess) {
        this.msg = msg;
        this.operationSuccess = operationSuccess;
    }

    public Packet(String msg, boolean operationSuccess) {
        this.msg = new String[]{msg};
        this.operationSuccess = operationSuccess;
    }

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public String[] getMsg() {
        return msg;
    }

    public List<String[]> getPosts() {
        return posts;
    }

    public List<String[]> getReplies() {
        return replies;
    }

    public void setMsg(String[] msg) {
        this.msg = msg;
    }

    public boolean isOperationSuccess() {
        return operationSuccess;
    }

    public Date getDate() {
        return date;
    }

    public void setOperationSuccess(boolean operationSuccess) {
        this.operationSuccess = operationSuccess;
    }

    @Override
    public String toString() {
        return "Packet{" + "requestType=" + requestType +
                ", msg=" + Arrays.toString(msg) +
                ", posts=" + posts +
                ", replies=" + replies +
                ", operationSuccess=" + operationSuccess +
                '}';
    }
}
