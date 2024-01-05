import service.CategoryService;
import service.TodoService;
import service.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        new IHM(new TodoService(), new UserService(), new CategoryService()).start();

    }
}
