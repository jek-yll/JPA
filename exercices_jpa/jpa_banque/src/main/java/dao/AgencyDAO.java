package dao;

import model.Agency;

public interface AgencyDAO {

    public boolean addAgency(Agency agency);

    public Agency getAgency(Long id);
}
