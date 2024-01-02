package demo;

import entity.Person;

import javax.persistence.*;
import java.util.List;

public class Demo2 {

    public static void main() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();

        transac.begin();

        Person person = em.getReference(Person.class, 55L);
        // System.out.println(person);
        try {

        } catch (EntityNotFoundException e){
            System.out.println("Entity non trouvé");
        }

        // Recuperation par Query
        // singleResult
        Query query = em.createQuery("select p from Person p where p.nom = 'voixdechiot'", Person.class);
        Person person2 = (Person) query.getSingleResult();
        System.out.println(person2);


        // resultList
        Query query1 = em.createQuery("select p from Person p where p.id > 2");
        List<Person> personsList = query1.getResultList();
        System.out.println(person2);

        for (Person p : personsList){
            System.out.println("Personne : " + p.getNom());
        }

        // Paramètres nommés :
        Query query2 = em.createQuery("select p from Person p where p.id > :id");
        query2.setParameter("id", 2L);
        List<Person> personsList2 = query2.getResultList();
        System.out.println(person2);

        for (Person p : personsList2){
            System.out.println("Personne (parametre nommé): " + p.getNom());
        }

        System.out.println("Modifier une occurence : ");

        Person person4 = em.find(Person.class, 4L);
        person4.setNom("Pesquet");
        person4.setPrenom("Jean-Michel");


        transac.commit();
        person4 = em.find(Person.class, 4L);
        System.out.println("Person : " + person4);

        em.close();
        emf.close();
    }
}
