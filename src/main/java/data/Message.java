package data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Entity
public class Message {

    @Id
    private String id;

    @Column
    private String message;

    @OneToOne(targetEntity = User.class)
    private User user;

    @Column
    private Date postedAt;

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    @Column
    private List<String> hashtags;


    public Message(){
    }

    public Message(User user, String message, Date postedAt, List<String> hashtags){
        this.user = user;
        this.message = message;
        this.postedAt = new Date();
        this.hashtags = hashtags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }
}
