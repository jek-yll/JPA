package service;

import dao.TodoDAO;
import model.Todo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoService implements ITodoService{

    private TodoDAO todoDAO;

    public TodoService(){
        todoDAO = new TodoDAO();
    }

    @Override
    public Todo createTodo(String title){
        Todo todo = new Todo(title);
        try {
            todoDAO.create(todo);
            return todo;
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Todo getTodoById(Long id) {
        try {
            return todoDAO.get(id);
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public boolean updateTodo(Long id) {
        try {
            Todo todo = todoDAO.get(id);
            return todoDAO.update(todo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeTodo(Long id) {
        try {
            Todo todo = todoDAO.get(id);
            todoDAO.delete(todo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Todo> getAllTodos() {
        List <Todo> todos = new ArrayList<>();
        try {
            todos = todoDAO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return todos;
    }
}
