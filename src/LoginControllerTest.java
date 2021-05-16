import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class LoginControllerTest {
    @Test
    public void loginAdmin() throws SQLException, ClassNotFoundException {
        LoginController log = new LoginController();
        Assert.assertEquals("admin", log.login("Katya", "12345"));

    }

    @Test
    public void loginUser() throws SQLException, ClassNotFoundException {
        LoginController log = new LoginController();
        Assert.assertEquals("user", log.login("User", "11111"));

    }

    @Test
    public void loginWithInvalidPassword() throws SQLException, ClassNotFoundException {
        LoginController log = new LoginController();
        Assert.assertEquals( "error", log.login("Katya", "1111"));

    }

    @Test
    public void loginInvalidAll() throws SQLException, ClassNotFoundException {
        LoginController log = new LoginController();
        Assert.assertEquals("error", log.login("tp", "feeee"));
    }

    @Test
    public void loginSqlInjection() throws SQLException, ClassNotFoundException {
        LoginController log = new LoginController();
        Assert.assertEquals("error", log.login("Katya", "NOT(NULL)"));
        Assert.assertEquals("error", log.login("NOT(NULL)", "12345"));
    }
}
