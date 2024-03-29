package service;

import model.Todo;

import java.sql.SQLException;
import java.util.List;

public interface ITodoService {

    public Todo createTodo(String title, String description, Integer priority, Long userId);
    public Todo getTodoById(Long id);
    public boolean updateTodo(Long id);
    public void removeTodo(Long id);
    public List<Todo> getAllTodos();

}
