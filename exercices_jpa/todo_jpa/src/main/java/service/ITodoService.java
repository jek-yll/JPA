package service;

import model.Todo;

public interface ITodoService {

    public Todo createTodo(String title);
    public Todo getTodoById(Long id);
    public void updateTodo();
    public void removeTodo();
    public void getAllTodos();

}
