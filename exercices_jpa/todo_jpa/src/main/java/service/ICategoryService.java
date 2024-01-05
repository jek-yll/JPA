package service;

import model.Category;
import model.Todo;

import java.util.List;

public interface ICategoryService {
    public Category createCategory(String name);
    public Boolean removeCategory(Long idCategory);
    public List<Todo> todosByCategory(Long idCategory);
    public boolean acdTodoToCategory(Long idTodo);
    public boolean removeTodoFromCategory(Long idTodo);
    public List<Category> getAllCategories();

}
