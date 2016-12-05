package utils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 */
@Entity
public class Message {

    @Id
    private int id;

    @Column
    private String message;

    @Column
    private  Personne personne;

    public Message(Personne personne, String message){
        this.personne = personne;
        this.message = message;

    }

}
