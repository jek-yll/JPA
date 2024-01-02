package demo;

import entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class Demo1 {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");

    public static void main() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person p1 = new Person("Jean", "Michel");
        em.persist(p1);
        System.out.println("person " + p1.getId());
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void find(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person p2 = em.find(Person.class, 2L);

        System.out.println(p2);
        em.close();
        emf.close();
    }

    public static void remove(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person p2 = em.find(Person.class, 2L);
        em.remove(p2);
        em.getTransaction().commit();

        System.out.println(p2);

        em.close();
        emf.close();
    }

    public static void createQuery(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p3 = new Person("Jean-michel", "voixdechiot");
        Person p4 = new Person("Jean-michel", "apeupres");

        em.persist(p3);
        em.persist(p4);

        List<Person> persons = null;
        persons = em.createQuery("select p from Person p", Person.class).getResultList();

        for (Person p: persons){
            System.out.println(p);
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
