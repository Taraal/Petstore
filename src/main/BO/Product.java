package main.BO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String code;

    public Product(Long id, String code, String label, ProdType type) {
    }

    @Column
    private String label;
    @Column
    private ProdType type;

    @ManyToMany(mappedBy = "products")
    private Set<Petstore> petstores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public Set<Petstore> getPetstores() {
        return petstores;
    }

    public void removePetStore(Petstore petstore){
        this.petstores.remove(petstore);
    }

    public void addPetstore(Petstore petstore) {
        this.petstores.add(petstore);
    }
}
