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
        em.close();
        emf.close();
    }

    @Override
    public void update(Todo element) throws SQLException {


    }

    @Override
    public void delete(Todo element) throws SQLException {
        transaction.begin();
        Long id = element.getId();
        Todo todo = em.find(Todo.class, id);
        em.remove(todo);
        transaction.commit();
        em.close();
        emf.close();
    }

    @Override
    public Todo get(Long id) throws SQLException {
        transaction.begin();
        Todo todo = em.find(Todo.class, id);
        return todo;
    }

    @Override
    public List<Todo> getAll() throws SQLException {
        transaction.begin();
        List<Todo> todos = null;
        todos = em.createQuery("select t from Todo t", Todo.class).getResultList();

        em.close();
        emf.close();

        return todos;
    }
}
