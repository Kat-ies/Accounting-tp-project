import java.sql.SQLException;

public class LoginController {
    public String login(String login, String password) throws SQLException, ClassNotFoundException {
        DataAccessor accessor = new DataAccessor();
        return accessor.doesUserExists(new User(login, password));
    }
}
