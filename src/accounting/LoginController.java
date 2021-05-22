package accounting;

import java.sql.SQLException;

public class LoginController {
    public User login(UserCredentials credentials) throws LoginException {
        User user = new User();
        try {
            if (accessor.authentificateUser(user, credentials)) {
                return user;
            }
        } catch (SQLException exc) {
            throw new LoginException("DB error: " + exc.getMessage());
        } catch (DataException exc) {
            throw new LoginException("Data error: " + exc.getMessage());
        }
        throw new LoginException("Invalid username or password");
    }

    public LoginController(DataAccessor accessor) {
        this.accessor = accessor;
    }

    private DataAccessor accessor;
}
