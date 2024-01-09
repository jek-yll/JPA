package controller;

import impl.AccountDAOImpl;
import impl.AgencyDAOImpl;
import impl.CustomerDAOImpl;
import model.Agency;
import model.Customer;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class IHM {
    private static EntityManagerFactory entityManagerFactory;
    private static AgencyDAOImpl agencyDAO;
    private static CustomerDAOImpl customerDAO;
    private static AccountDAOImpl accountDAO;

    public static void main(){
        entityManagerFactory = Persistence.createEntityManagerFactory("banque_bdd");
        agencyDAO = new AgencyDAOImpl(entityManagerFactory);
        customerDAO = new CustomerDAOImpl(entityManagerFactory);
        accountDAO = new AccountDAOImpl(entityManagerFactory);

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("##### GESTION BANQUES #####");
            System.out.println("1- Création d'une agence");
            System.out.println("2- Création d'un client");
            System.out.println("3- Création d'un compte bancaire");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    addAgency(scanner);
                    break;
                case 2:
                    addCustomer(scanner);
                    break;
                case 3:
                    addAccount(scanner);
                    break;
                default:
                    System.out.println("Erreur de saisi, veuillez recommencer");
            }
        }while (choice != 0);

    }

    private static void addAgency(Scanner scanner){
        System.out.println("CREATION AGENCE");
        System.out.println("Saisir l'addresse de l'agence");
        String address = scanner.nextLine();

        Agency agency = new Agency();
        agency.setAddress(address);

        if (agencyDAO.addAgency(agency)){
            System.out.println("Agence créée avec succès !");
        } else {
            System.out.println("Erreur");
        }
    }

    private static void addCustomer(Scanner scanner){
        System.out.println("CREATION CLIENT");
        System.out.println("Saisir le nom du client");
        String lastname = scanner.nextLine();

        System.out.println("Saisir le prenom du client");
        String firstname = scanner.nextLine();

        System.out.println("Saisir la date de naissance du client");
        String dateOfBirth = scanner.nextLine();

        System.out.println("Dans quel agence rattacher ce client :");
        Long agencyId = scanner.nextLong();
        scanner.nextLine();

        Customer customer = new Customer();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setDateOfBirth(dateOfBirth);


        if (customerDAO.addCustomer(customer, agencyId)){
            System.out.println("Agence créée avec succès !");
        } else {
            System.out.println("Erreur");
        }

    }

    private static void addAccount(Scanner scanner){

    }
}
