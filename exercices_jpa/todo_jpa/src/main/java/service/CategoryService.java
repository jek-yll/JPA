package service;

import dao.CategoryDAO;
import dao.TodoDAO;
import model.Category;
import model.Todo;

import java.util.List;

public class CategoryService implements ICategoryService{

    private CategoryDAO categoryDAO;

    public CategoryService(){categoryDAO = new CategoryDAO();}

    @Override
    public Category createCategory(String name) {
        Category category = new Category(name);
        categoryDAO.create(category);
        return category;
    }

    @Override
    public Boolean removeCategory(Long idCategory) {
        try {
            return categoryDAO.delete(idCategory);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Todo> todosByCategory(Long idCategory) {
        return null;
    }

    @Override
    public boolean addTodoToCategory(Long idTodo, Long idCategory) {
        TodoDAO todoDAO = new TodoDAO();

        Category category = categoryDAO.get(idCategory);
        category.getTodos().add(todoDAO.get(idTodo));
        categoryDAO.addTodoToCategorie(category);

        return false;
    }

    @Override
    public boolean removeTodoFromCategory(Long idTodo) {
        return false;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.getAll();
    }

}
