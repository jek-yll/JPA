package demo;

import entity.manyToMany.Post;
import entity.manyToMany.Tag;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo6 {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");

    public static void main() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Post post = new Post();
        Post post1 = new Post();
        post.setTitle("Dormir");
        post1.setTitle("Courir");

        Tag tag = new Tag();
        Tag tag1 = new Tag();
        tag.setName("genant");
        tag1.setName("pas cool");

        post.getTags().add(tag);
        post.getTags().add((tag1));
        post1.getTags().add(tag1);

        em.persist(post1);
        em.persist(post);

        em.getTransaction().commit();

        Tag tag2 = em.find(Tag.class, 2L);
        Post post2 = em.find(Post.class, 2L);

        System.out.println(tag2);
        System.out.println(post2);

        em.close();
        emf.close();

    }
}
