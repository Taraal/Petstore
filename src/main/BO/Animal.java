package main.BO;

import org.hibernate.boot.model.process.internal.ManagedResourcesImpl;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PETSTORE_ID")
    Petstore petstore;

    public Petstore getPetstore() {
        return petstore;
    }

    public void setPetstore(Petstore petstore) {
        this.petstore = petstore;
    }

    @Column
    private Date birth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Column
    private String couleur;

    public Animal(){

    }

    public Animal(Date birth, String couleur){
        this.birth = birth;
        this.couleur = couleur;
    }

    public Animal(Long id, Date birth, String couleur){
        this();
        this.id = id;
        this.birth = birth;
        this.couleur = couleur;
    }

    
}
