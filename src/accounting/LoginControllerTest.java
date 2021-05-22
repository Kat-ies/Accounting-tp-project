package accounting;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginControllerTest {
    private DataAccessor accessor;
    private LoginController controller;

    @Before
    public void setUp() throws Exception {
        accessor = new DataAccessor("jdbc:sqlite::memory:");
        controller = new LoginController(accessor);
        accessor.fillTestData();
    }

    @After
    public void tearDown() throws Exception {
        accessor.close();
    }

    @Test
    public void logInAdmin() throws LoginException {
        Assert.assertEquals(
                new User("Katya", Role.ADMIN),
                controller.login(new UserCredentials("Katya", "12345")));
    }

    @Test
    public void logInUser() throws LoginException {
        Assert.assertEquals(
                new User("User", Role.ACCOUNTANT),
                controller.login(new UserCredentials("User", "11111")));

    }

    @Test(expected = LoginException.class)
    public void logInWithInvalidPassword() throws LoginException {
        controller.login(new UserCredentials("Katya", "11111"));
    }


    @Test(expected = LoginException.class)
    public void logInWithInvalidName() throws LoginException {
        controller.login(new UserCredentials("tp", "feeee"));
    }

    @Test(expected = LoginException.class)
    public void logInWithSqlInjectionFirst() throws LoginException {
        controller.login(new UserCredentials("Katya", "NOT(NULL)"));
    }

    @Test(expected = LoginException.class)
    public void logInWithSqlInjectionSecond() throws LoginException {
        controller.login(new UserCredentials("NOT(NULL)", "12345"));
    }
}
