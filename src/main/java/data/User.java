package data;

import application.forms.SignUpForm;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */
@Entity
public class User implements Serializable {


    @Id
    private String id;
    @Column(unique = true)
    private String userName;
    @Column
    private String mail;
    @Column
    private String phone = "";
    @Column
    private String twitter = "";
    @Column
    private String facebook = "";
    @Column
    private String linkedin = "";
    @Column
    @JsonIgnore
    private String password;


    public User() {}

    public User(SignUpForm form) {
        this.userName = form.getUserName();
        this.password = form.getPassword();
        this.mail = form.getMail();
        this.twitter = form.getTwitter();
        this.facebook = form.getFacebook();
        this.linkedin = form.getLinkedin();
    }

    public User(String userName, String mail, String phone, String twitter, String facebook, String linkedin, String password) {
        this.userName = userName;
        this.mail = mail;
        this.phone = phone;
        this.twitter = twitter;
        this.facebook = facebook;
        this.linkedin = linkedin;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(Object o) {
        if (!(o instanceof User))
            return false;
        return this.id.equals(((User) o).id);
    }
}
