package service;

import dao.TodoDAO;
import model.InfosTodo;
import model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService implements ITodoService{

    private TodoDAO todoDAO;

    public TodoService(){
        todoDAO = new TodoDAO();
    }

    @Override
    public Todo createTodo(String title, String description, Integer priority){
        Todo todo = new Todo(title, new InfosTodo(description, priority));
        todoDAO.create(todo);
        return todo;
    }

    @Override
    public Todo getTodoById(Long id) {
        return null;
    }

    @Override
    public boolean updateTodo(Long id) {
        Todo todo = todoDAO.get(id);
        return todoDAO.update(todo);
    }

    @Override
    public void removeTodo(Long id) {
        Todo todo = todoDAO.get(id);
        todoDAO.delete(id);
    }

    @Override
    public List<Todo> getAllTodos() {
        List <Todo> todos = new ArrayList<>();
        todos = todoDAO.getAll();
        return todos;
    }
}
