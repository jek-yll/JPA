package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO<T> {
    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction transaction;

    protected BaseDAO(){
        emf = Persistence.createEntityManagerFactory("todo");
        em = emf.createEntityManager();
        transaction = em.getTransaction();
    }

    public abstract void create(T element) throws SQLException;
    public abstract void update(T element) throws SQLException;
    public abstract void delete (T element) throws SQLException;
    public abstract T get(Long id) throws SQLException;
    public abstract List<T> getAll() throws SQLException;

}
