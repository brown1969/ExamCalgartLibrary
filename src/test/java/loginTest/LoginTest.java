package loginTest;

import baseTest.BaseTest;
import org.junit.Test;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class LoginTest extends BaseTest {

@Test
public void validLogin() {
    pageProvider.getLoginPage().openLoginPage();
    pageProvider.getLoginPage().clickOnButtonLogin();
    pageProvider.getLoginPage().clickOnButtonSignInWithEmail();
    pageProvider.getLoginPage().enterTextIntoInputUserNameOrEmail(LOGIN_DEFAULT);
    pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
    pageProvider.getLoginPage().clickOnButtonSecondLogin();
    pageProvider.getLoginPage().checkLogOutButtonIsDisplayed();
    pageProvider.getLoginPage().checkUserProfileButtonIsDisplayed();



}

}
