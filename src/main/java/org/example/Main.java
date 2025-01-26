package org.example;

import com.github.javafaker.Faker;
import org.example.entities.catalogo.Book;
import org.example.entities.catalogo.Megazine;
import org.example.entities.catalogo.Prestito;
import org.example.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class Main 
{
    public static void main( String[] args ) {

       EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d12");
       EntityManager em = emf.createEntityManager();
       EntityTransaction transaction = em.getTransaction();

       Faker faker = new Faker();

       try{
           transaction.begin();

           for (int i=0; i<5; i++) {
               Book book = new Book();
               book.setISBN(faker.code().isbn10());
               book.setTitle(faker.book().title());
               book.setPub(faker.number().numberBetween(1000, 2020));
               book.setNpage(faker.number().numberBetween(50, 3000));
               book.setAuthor(faker.book().author());
               book.setGenre(faker.book().genre());

               em.persist(book);
           }

           for (int i=0; i<5; i++) {
               Megazine megazine = new Megazine();
               megazine.setISBN(faker.code().isbn10());
               megazine.setTitle(faker.book().title());
               megazine.setPub(faker.number().numberBetween(1700, 2020));
               megazine.setNpage(faker.number().numberBetween(50, 3000));
               megazine.setPeriodic(faker.options().option());

               em.persist(megazine);
           }

           for (int i=0; i<5; i++){
               User user = new User();
               user.setName(faker.name().firstName());
               user.setSurname(faker.name().lastName());
               user.setBirth(faker.date().birthday());
               user.setTessera(faker.number().randomNumber(5, true));

               em.persist(user);
           }

           Book libroPrestato = em.createQuery("selezione libro", Book.class).setMaxResults(1).getSingleResult();
           User utente = em.createQuery("utente", User.class).setMaxResults(1).getSingleResult();

           Prestito prestito = new Prestito();
           prestito.setUser(utente);
           prestito.setBiblioteca(libroPrestato);
           prestito.setInizioPrestito(new Date());
           prestito.setFinePrestito(new Date(System.currentTimeMillis()));

           em.persist(prestito);

           transaction.commit();
       } catch (Exception e){
           if(transaction.isActive()){
               transaction.rollback();
           }
           e.printStackTrace();
       } finally {
           em.close();
           emf.close();
       }

    }
}
