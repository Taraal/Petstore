package main.BO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PETSTORE")
public class Petstore implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @OneToOne(mappedBy = "petstore", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private Address address;

    @OneToMany(mappedBy = "petstore", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private Set<Animal> animals;

    @ManyToMany
    @JoinTable(name = "prod_store",
            joinColumns = @JoinColumn(name = "ID_STORE", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_PROD", referencedColumnName = "ID")
    )
    private Set<Product> products;


    public Petstore() {
    }



    public Petstore(Long id){
        this();
        this.id  = id;
    }

    public Petstore(Long id, String name, Address address){
        this();
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void setAnimals( Set<Animal> animals ) {
    		this.animals = animals;
    	}

    public Set<Animal> getAnimals(){
        return this.animals;
    }

    public void addAnimal( Animal animal ) {
        animal.setPetstore( this );
    }

    public void removeAnimal( Animal animal ) {
        animal.setPetstore( null );
    }

    public Set<Product> getProducts(){
        return this.products;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }

    public void setProducts(Set<Product> products){
        this.products = products;
    }

}
