import model.Category;
import model.Todo;
import service.ICategoryService;
import service.ITodoService;
import service.IUserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class IHM {
    private Scanner sc;
    private String choix;
    private ITodoService _todoService;
    private IUserService _userService;
    private ICategoryService _categoryService;

    public IHM(ITodoService todoService, IUserService userService, ICategoryService categoryService){
        sc = new Scanner(System.in);
        _todoService = todoService;
        _userService = userService;
        _categoryService = categoryService;
    }

    public void start() throws SQLException {
        do {
            menu();
            choix = sc.nextLine();
            switch (choix) {
                case "1":
                    createTodo();
                    break;
                case "2":
                    getTodo();
                    break;
                case "3":
                    updateTodo();
                    break;
                case "4":
                    removeTodo();
                    break;
                case "5":
                    getAllTodos();
                    break;
                case "6":
                    createUser();
                    break;
                case "7":
                    deleteUser();
                case "8":
                    getAllTodosByUser();
                case "9":
                    addCategorie();
                case "10":
                    removeCategorie();
                case"11":
                    //todosByCategorie();
                case"12":
                    addTodoToCategorie();
                case "13":
                    removeTodoFromCategorie();




            }
        } while (!choix.equals("0"));
    }

    private void menu(){
        System.out.println("\n########## Menu Principal ##########");
        System.out.println("1- Création d'une Todo");
        System.out.println("2- Recherche d'une Todo");
        System.out.println("3- Modification d'une Todo");
        System.out.println("4- Suppression d'une Todo");
        System.out.println("5- Affichage des Todos");
        System.out.println("6- Création d'un utilisateur");
        System.out.println("7- Suppression d'un utilisateur");
        System.out.println("8- Afficher les todos d'un utilisateur");
        System.out.println("9- Ajouter une catégorie");
        System.out.println("10- Supprimer une catégorie");
        System.out.println("11- Afficher les Todos d'une catégorie");
        System.out.println("12- Ajouter une Todo à une catégorie");
        System.out.println("13- Supprimer une tache d'une catégorie");
        System.out.println("0- Quitter");
        System.out.println("Votre choix : ");
    }

    private void createTodo() {
        System.out.println("########## Création d'une Todo ##########");
        System.out.println("Saisir votre identifiant utilisateur");
        Long userId = sc.nextLong();
        sc.nextLine();
        System.out.println("Saisir le titre de votre Todo : ");
        String title = sc.nextLine();
        System.out.println("Saisir une description pour votre Todo :");
        String description = sc.nextLine();
        System.out.println("Priorité de la Todo : ");
        Integer priority = sc.nextInt();
        sc.nextLine();
        _todoService.createTodo(title, description, priority, userId);
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

    private void createUser(){
        System.out.println("########## Création d'un utilisateur ##########");
        System.out.println("Saisir le nom de l'utilisateur : ");
        String name = sc.nextLine();
        _userService.createUser(name);
    }

    private void deleteUser(){
        System.out.println("########## Suppression d'un utilisateur ##########");
        System.out.println("Saisir l'identifiant de l'utilisateur à supprimer");
        Long userId = sc.nextLong();
        sc.nextLine();
        _userService.removeUser(userId);
    }

    private void getAllTodosByUser(){
        System.out.println("########## TodoList d'un utilisateur ##########");
        System.out.println("Saisir l'identifiant utilisateur");
        Long userId = sc.nextLong();
        sc.nextLine();
        List<Todo>todos = _userService.getAllTodoByUser(userId);
        for (Todo t : todos) {
            System.out.println(t);
        }
    }
    
    private void addCategorie(){
        System.out.println("########## Ajout d'une catégorie ##########");
        System.out.println("Saisir le nom :");
        String name = sc.nextLine();
        _categoryService.createCategory(name);
    }

    private void removeCategorie(){
        System.out.printf("########## Suppression d'une catégorie ##########");
        if (displayCategories()){
            System.out.println("id de la catégorie à supprimer");
            Long idCategorie = sc.nextLong();
            sc.nextLine();
            if (_categoryService.removeCategory(idCategorie)){
                System.out.println("catégorie " + idCategorie + " supprimé avec succès");
            } else {
                System.out.println("echec lors de la suppression de la catégorie");
            };
        }
    }

    private void addTodoToCategorie(){
        
    }
    
    private void removeTodoFromCategorie(){
        
    }

    private boolean displayCategories(){
        List <Category> categories = _categoryService.getAllCategories();
        System.out.println("------------Catégories :-------------");
        if (!categories.isEmpty()){
            for (Category c : categories) {
                System.out.printf( c.getId() + " -> " + c.getName() + "\n");
            }
            return true;
        } else {
            System.out.println("Aucune catégorie à afficher");
            return false;
        }
    }

    private void displayTodos(){
        List <Todo> todos = _todoService.getAllTodos();
        System.out.println("------------Todos :-------------");
        if (!todos.isEmpty()){
            for (Todo t : todos) {
                System.out.printf( t.getId() + " -> " + t.getTitle());
            }
        } else {
            System.out.printf("Aucune todo à afficher");
        }
    }

}
