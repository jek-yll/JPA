package dao;

import model.Todo;

import java.sql.SQLException;
import java.util.List;

public class TodoDAO extends BaseDAO<Todo> {

    @Override
    public void create(Todo element) throws SQLException {
        transaction.begin();
        em.persist(element);
        transaction.commit();
        //em.close();
        //emf.close();
    }

    @Override
    public boolean update(Todo element) throws SQLException {
        transaction.begin();
        if (element.getIsDone()){
            return false;
        } else {
            element.setIsDone(!element.getIsDone());
            em.persist(element);
            transaction.commit();
            return true;
        }
    }

    @Override
    public void delete(Todo todo) throws SQLException {
        transaction.begin();
        em.remove(todo);
        transaction.commit();
        //em.close();
        //emf.close();
    }

    @Override
    public Todo get(Long id) throws SQLException {
        //transaction.begin();
        Todo todo = em.find(Todo.class, id);
        return todo;
    }

    @Override
    public List<Todo> getAll() throws SQLException {
        List<Todo> todos = null;
        todos = em.createQuery("select t from Todo t", Todo.class).getResultList();

        //em.close();
        //emf.close();

        return todos;
    }
}
