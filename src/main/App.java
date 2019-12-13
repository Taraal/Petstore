package main;

import main.BO.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {

    public static void main(String[] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");

        EntityManager em = emf.createEntityManager();

        Address address1 = new Address("45", "Quai Magellan", "44000", "Nantes");
        Address address2 = new Address("3", "Rue de Guerande", "44100", "Nantes");
        Address address3 = new Address("4", "Allee Velasquez", "44200", "Nantes");

        Petstore petstore1 = new Petstore((long) 1, "Vive les animaux", address1);
        Petstore petstore2 = new Petstore((long) 2, "Animal land", address2);
        Petstore petstore3 = new Petstore((long) 3, "La ferme des animaux", address3);


        Fish fish1 = new Fish(FishLivEnv.SEA_WATER);
        fish1.setId((long) 1); fish1.setBirth(new Date()); fish1.setCouleur("Rouge");
        Fish fish2 = new Fish(FishLivEnv.FRESH_WATER);
        fish1.setId((long) 2); fish1.setBirth(new Date()); fish1.setCouleur("Bleu");
        Fish fish3 = new Fish(FishLivEnv.SEA_WATER);
        fish1.setId((long) 3); fish1.setBirth(new Date()); fish1.setCouleur("Jaune");

        petstore1.addAnimal(fish1);
        petstore2.addAnimal(fish2);
        petstore3.addAnimal(fish3);

        Cat cat1 = new Cat("id1");
        cat1.setId((long)1); cat1.setBirth(new Date()); cat1.setCouleur("Noir");
        Cat cat2 = new Cat("id2");
        cat2.setId((long)2); cat2.setBirth(new Date()); cat2.setCouleur("Blanc");
        Cat cat3 = new Cat("id3");
        cat3.setId((long)3); cat3.setBirth(new Date()); cat3.setCouleur("Calico");

        petstore1.addAnimal(cat1);
        petstore2.addAnimal(cat2);
        petstore3.addAnimal(cat3);

        Product prod1 = new Product((long)1, "1234", "laisse", ProdType.ACCESSORY);
        Product prod2 = new Product((long)1, "2345", "Litiere", ProdType.CLEANING);
        Product prod3 = new Product((long)1, "3456", "Croquettes", ProdType.FOOD);

        petstore1.addProduct(prod1); petstore1.addProduct(prod2);
        petstore2.addProduct(prod2); petstore2.addProduct(prod3);
        petstore3.addProduct(prod3); petstore3.addProduct(prod1);

        em.getTransaction();
        em.persist(petstore1);
        em.persist(petstore2);
        em.persist(petstore3);
        em.getTransaction().commit();

        System.out.println(petstore1.getAnimals());

        emf.close();

    }
}
