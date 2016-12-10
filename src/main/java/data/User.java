package data;

import application.forms.SignupForm;

import javax.persistence.*;

/**
 *
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String userName;
    @Column
    private String mail;
    @Column
    private String phone;
    @Column
    private String twitter;
    @Column
    private String facebook;
    @Column
    private String linkedin;


    public User() {}

    public User(SignupForm form) {
        this.userName = form.getUserName();
        this.mail = form.getMail();
        this.twitter = form.getTwitter();
        this.facebook = form.getFacebook();
        this.linkedin = form.getLinkedin();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
