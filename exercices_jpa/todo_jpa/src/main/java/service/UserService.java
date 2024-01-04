package service;

import dao.UserDAO;
import model.Todo;
import model.User;

import java.util.List;

public class UserService implements IUserService{

    private UserDAO userDAO;

    public UserService(){
        userDAO = new UserDAO();
    }

    @Override
    public void createUser(String name) {
        User user = new User(name);
        userDAO.create(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.get(id);
    }

    @Override
    public boolean removeUser(Long id) {
        userDAO.delete(id);
        return true;
    }

    @Override
    public List<Todo> getAllTodoByUser(Long userId) {
        User user = userDAO.get(userId);
        return user.getTodos();
    }
}
