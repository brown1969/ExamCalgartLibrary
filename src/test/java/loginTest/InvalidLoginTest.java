package loginTest;

import baseTest.BaseTest;
import org.junit.Test;

public class InvalidLoginTest extends BaseTest {
    @Test
    public void invalidLogin() {
        pageProvider.getLoginPage().loginWithInValidCreds();
        pageProvider.getLoginPage().checkLogInButtonIsDisplayed();

    }
}
