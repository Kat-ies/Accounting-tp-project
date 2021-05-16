import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class LoginControllerTest {

    @Test
    public void loginKatya() throws SQLException, ClassNotFoundException {
        LoginController log = new LoginController();
        Assert.assertEquals(true, log.login("Katya", "12345"));

    }

    @Test
    public void loginWithInvalidPassword() throws SQLException, ClassNotFoundException {
        LoginController log = new LoginController();
        Assert.assertEquals( false, log.login("Katya", "1111"));

    }

    @Test
    public void loginInvalidAll() throws SQLException, ClassNotFoundException {
        LoginController log = new LoginController();
        Assert.assertEquals(false, log.login("tp", "feeee"));
    }

    @Test
    public void loginSqlInjection() throws SQLException, ClassNotFoundException {
        LoginController log = new LoginController();
        Assert.assertEquals(false, log.login("Katya", "NOT(NULL)"));
        Assert.assertEquals(false, log.login("NOT(NULL)", "12345"));
    }
}
