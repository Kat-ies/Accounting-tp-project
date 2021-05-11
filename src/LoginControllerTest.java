import org.junit.Assert;
import org.junit.jupiter.api.Test;

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
        Assert.assertEquals(true, log.login("tp", "feeee"));

    }
}