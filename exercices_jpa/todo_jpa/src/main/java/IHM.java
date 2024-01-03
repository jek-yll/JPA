import model.Todo;
import service.ITodoService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class IHM {
    private Scanner sc;
    private String choix;
    private ITodoService _todoService;

    public IHM(ITodoService todoService){
        sc = new Scanner(System.in);
        _todoService = todoService;
    }

    public void start() throws SQLException {
        do {
            menu();
            choix = sc.nextLine();
            switch (choix) {
                case "1":
                    // CREATE
                    createTodo();
                    break;
                case "2":
                    //READ
                    getTodo();
                    break;
                case "3":
                    //UPDATE
                    updateTodo();
                    break;
                case "4":
                    //DELETE
                    removeTodo();
                    break;
                case "5":
                    //GETALL
                    getAllTodos();
                    break;
            }
        } while (!choix.equals("0"));
    }

    private void menu(){
        System.out.println("########## Menu Principal ##########");
        System.out.println("1- Création d'une Todo");
        System.out.println("2- Recherche d'une Todo");
        System.out.println("3- Modification d'une Todo");
        System.out.println("4- Suppression d'une Todo");
        System.out.println("5- Affichage des Todos");
        System.out.println("0- Quitter");
        System.out.println("Votre choix : ");
    }

    private void createTodo() {
        System.out.println("########## Création d'une Todo ##########");
        System.out.println("Saisir le titre de votre Todo : ");
        String title = sc.nextLine();
        _todoService.createTodo(title);
    }

    private void getTodo(){
        System.out.println("########## Recherche d'une Todo ##########");
        System.out.println("Saisir l'identifiant de la Todo recherché");
        Long id = sc.nextLong();
        sc.nextLine();
        Todo todo = _todoService.getTodoById(id);
        System.out.println(todo);
    }

    private void getAllTodos(){
        System.out.println("########## La Todo Liste ##########");
        List <Todo> todos = _todoService.getAllTodos();
        for (Todo t : todos) {
            System.out.println(t);
        }
    }

    private void removeTodo(){
        System.out.println("########## Suppression d'une Todo ##########");
        System.out.println("Saisir l'identifiant de la Todo à supprimé");
        Long id = sc.nextLong();
        sc.nextLine();
        _todoService.removeTodo(id);
    }

    private void updateTodo(){
        System.out.println("########## Mise à jour d'une tache ##########");
        System.out.println("Saisir l'identifiant de la Todo Terminé");
        Long id = sc.nextLong();
        sc.nextLine();
        if (_todoService.updateTodo(id)){
            System.out.println("todo n° "+ id + " terminé");
        } else {
            System.out.println("todo deja terminé");
        };
    }

}
