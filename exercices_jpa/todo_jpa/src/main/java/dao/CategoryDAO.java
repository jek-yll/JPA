package dao;

import model.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends BaseDAO<Category>{
    @Override
    public boolean create(Category category){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(category);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Category category = em.find(Category.class, id);
            if(category != null){
                em.remove(category);
                transaction.commit();
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }finally {
            em.close();
        }
    }

    @Override
    public List<Category> getAll(){
        List<Category> categories = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        categories = em.createQuery("select t from Category t", Category.class).getResultList();
        em.close();
        return categories;
    }

    @Override
    public Category get(Long id) {
        EntityManager em = emf.createEntityManager();
        Category category = em.find(Category.class, id);
        em.close();
        return category;
    }

    public boolean addTodoToCategorie(Category categoryUpdated){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(categoryUpdated);
        transaction.commit();
        em.close();
        return true;
    }

    @Override
    public boolean update(Category element) {
        return false;
    }
}
