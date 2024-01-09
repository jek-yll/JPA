package impl;

import dao.AccountDAO;
import model.Account;
import model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class AccountDAOImpl implements AccountDAO {

    private EntityManagerFactory entityManagerFactory;

    public AccountDAOImpl(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }
    @Override
    public boolean addAccount(Account account, Long customerId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Customer customer = entityManager.find(Customer.class, customerId);

        account.getCustomers().add(customer);
        entityManager.persist(account);
        transaction.commit();
        entityManager.close();
        return true;

    }
}
