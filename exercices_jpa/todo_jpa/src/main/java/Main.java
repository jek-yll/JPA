import service.TodoService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        new IHM(new TodoService()).start();

    }
}
