package model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;
    @Column(nullable = false)
    private String libelle;
    @Column(length = 27, nullable = false)
    private String iban;
    @Column(length = 10, precision = 2)
    private Double balance;
    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;
    @ManyToMany
    private List<Customer> customers = new ArrayList<>();

    public Account(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }
}
