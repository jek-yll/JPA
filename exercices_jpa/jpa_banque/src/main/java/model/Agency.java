package model;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agency_id")
    private Long id;
    private String address;
    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts = new ArrayList<>();
    @OneToMany(mappedBy = "agency", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Customer> customers = new ArrayList<>();

    public Agency(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", customers=" + customers +
                '}';
    }
}
