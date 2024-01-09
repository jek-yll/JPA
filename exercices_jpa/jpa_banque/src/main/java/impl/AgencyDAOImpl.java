package impl;

import dao.AgencyDAO;
import model.Agency;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class AgencyDAOImpl implements AgencyDAO {

    private EntityManagerFactory entityManagerFactory;

    public AgencyDAOImpl(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }
    @Override
    public boolean addAgency(Agency agency) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(agency);
        transaction.commit();
        entityManager.close();
        return true;
    }

    @Override
    public Agency getAgency(Long id) {
        return null;
    }


}
