package data;

import javax.persistence.*;
import java.util.Date;

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


    public Message(){
    }

    public Message(User user, String message, Date postedAt){
        this.user = user;
        this.message = message;
        this.postedAt = new Date();
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
