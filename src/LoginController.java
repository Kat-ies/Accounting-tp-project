import java.sql.SQLException;

public class LoginController {
    public boolean login(String login, String password) throws SQLException, ClassNotFoundException {
        DataAccessor accessor = new DataAccessor();
        String message = accessor.doesUserExists(new User(login, password));
        if (message.equals("error")) {
            System.out.println("Invalid login or password");
            return false;
        } else {
            System.out.println("Welcome to the system, you're in " + message + " mode!");
            return true;
        }
    }
}
