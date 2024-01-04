package dao;

import model.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO extends BaseDAO<Todo> {

    @Override
    public boolean create(Todo todo) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(todo);
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
    public boolean update(Todo element)  {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            if (!element.getIsDone()){
                transaction.begin();
                element.setIsDone(!element.getIsDone());
                transaction.commit();
                return true;
            } else {
                return false;
            }

        } catch (Exception e){
            if(transaction.isActive()){
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
            Todo todo = em.find(Todo.class, id);
            if(todo != null){
                em.remove(todo);
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
    public List<Todo> getAll() {
        List<Todo> todos = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        todos = em.createQuery("select t from Todo t", Todo.class).getResultList();
        em.close();
        return todos;
    }

    @Override
    public Todo get(Long id) {
        EntityManager em = emf.createEntityManager();
        Todo todo = em.find(Todo.class, id);
        em.close();
        return todo;
    }
}
