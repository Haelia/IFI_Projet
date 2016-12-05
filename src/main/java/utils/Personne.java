package utils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 */
@Entity
public class Personne {

    @Id
    private int id;

    @Column
    private String prenom;

    @Column
    private String nom;

    @Column
    private String mail;

    @Column
    private String tel;

    public Personne(String prenom, String nom, String mail, String tel){
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.tel = tel;
    }
}
