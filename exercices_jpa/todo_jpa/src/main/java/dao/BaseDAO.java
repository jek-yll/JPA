package dao;

import model.InfosTodo;
import model.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO<T> {
    protected EntityManagerFactory emf;

    protected BaseDAO(){
        emf = Persistence.createEntityManagerFactory("todo");
    }

    public abstract boolean create(T element) throws SQLException;
    public abstract boolean update(T element) throws SQLException;
    public abstract boolean delete (Long id) throws SQLException;
    public abstract List<T> getAll() throws SQLException;
    public abstract T get(Long id);
}
