package service;

import dao.TodoDAO;
import model.Todo;

import java.sql.SQLException;

public class TodoService implements ITodoService{

    private TodoDAO todoDAO;

    public TodoService(){
        todoDAO = new TodoDAO();
    }

    @Override
    public Todo createTodo(String title) {
        return null;
    }

    @Override
    public Todo getTodoById(Long id) {
        return null;
    }

    @Override
    public void updateTodo() {

    }

    @Override
    public void removeTodo() {

    }

    @Override
    public void getAllTodos() {

    }
}
