package data;

import javax.persistence.*;

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

    public Message(){}

    public Message(User user, String message){
        this.user = user;
        this.message = message;

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
}
