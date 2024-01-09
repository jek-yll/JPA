package dao;

import model.Account;

public interface AccountDAO {

    public boolean addAccount(Account account,  Long customerId);
}
