package dao;

import model.Customer;

public interface CustomerDAO {

    public boolean addCustomer(Customer customer, Long id);
}
