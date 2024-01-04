package service;

import model.Todo;
import model.User;


import java.util.List;

public interface IUserService {

    public void createUser(String name);
    public User getUserById(Long id);
    public boolean removeUser(Long id);
    public List<Todo> getAllTodoByUser(Long userId);

}
