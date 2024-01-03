package demo;

import entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Demo3 {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");

    public static void main() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p1 = new Person("Toto", "Titit");
        em.persist(p1);
        System.out.println("person " + p1.getId());
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void merge() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("select p from Person p where p.id = 1");

        Person person = (Person) query.getSingleResult();

        if (person == null){
            System.out.println("Person not found");
        } else {
            System.out.println("Person : "+ person.getPrenom());
        }

        Person person1 = new Person();
        person1.setId(person.getId());
        person1.setPrenom(person.getPrenom());
        person1.setNom("Louis");

        em.merge(person1);

        person = (Person) query.getSingleResult();
        System.out.println("person : " + person.getPrenom());

        em.getTransaction().commit();
        em.close();
        emf.close();

    }

    public static void refresh() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Person person = em.find(Person.class, 1L);
            System.out.println("Person : " + person);
            if (person == null) {
                System.out.println("Personne not found");
            } else {
                Thread.sleep(15000);

                em.refresh(person);
                System.out.println("Person : " + person);

            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        em.close();
        emf.close();
    }
}
