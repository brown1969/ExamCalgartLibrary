package loginTest;

import baseTest.BaseTest;
import org.junit.Test;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {
    @Test
    public void invalidLogin() {
        pageProvider.getLoginPage().loginWithInValidCreds();

    }
}
