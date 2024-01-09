package impl;

import dao.CustomerDAO;
import model.Agency;
import model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class CustomerDAOImpl implements CustomerDAO {

    private EntityManagerFactory entityManagerFactory;

    public CustomerDAOImpl(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }
    @Override
    public boolean addCustomer(Customer customer, Long agencyId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Agency agency = entityManager.find(Agency.class, agencyId);
        agency.getCustomers().add(customer);

        entityManager.persist(customer);
        transaction.commit();
        entityManager.close();
        return true;
    }
}
