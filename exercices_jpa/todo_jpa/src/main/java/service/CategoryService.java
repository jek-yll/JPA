package service;

import dao.CategoryDAO;
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
        return Category;
    }

    @Override
    public Boolean removeCategory(Long idCategory) {
        return null;
    }

    @Override
    public List<Todo> todosByCategory(Long idCategory) {
        return null;
    }

    @Override
    public boolean acdTodoToCategory(Long idTodo) {
        return false;
    }

    @Override
    public boolean removeTodoFromCategory(Long idTodo) {
        return false;
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

}
