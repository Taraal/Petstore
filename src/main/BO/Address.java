package main.BO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String number;
    @Column
    private String street;
    @Column
    private String zipCode;
    @Column
    private String city;
    @OneToOne
    @JoinColumn(name = "PETSTORE_ADDRESS")
    private Petstore petstore;

    public Address() {}

    public Address( String number, String street, String zipCode, String city ) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber( String number ) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet( String street ) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode( String zipCode ) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }

    public Petstore getPetstore() {
        return petstore;
    }

    public void setPetstore( Petstore petstore ) {
        this.petstore = petstore;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer( "Address{" );
        sb.append( "number='" ).append( number ).append( '\'' );
        sb.append( ", street='" ).append( street ).append( '\'' );
        sb.append( ", zipCode='" ).append( zipCode ).append( '\'' );
        sb.append( ", city='" ).append( city ).append( '\'' );
        sb.append( '}' );
        return sb.toString();
    }
}
