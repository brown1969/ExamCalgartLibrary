package registrationTest;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)

public class RegistrationTest extends baseTest.BaseTest {

    final static String ERROR_USERNAME = "\"Name\" field contains invalid characters";
    final static String ERROR_EMAIL = "\"e-mail\" field contains invalid characters";
    final static String ERROR_PASSWORD = "\"Password\" field contains invalid characters";
    final static String ERROR_USERNAME_EMPTY = "Fill in \"Name\" field";
    final static String ERROR_EMAIL_EMPTY = "Fill in \"Email\" field";
    final static String ERROR_PASSWORD_EMPTY = "Fill in \"Password\" field";
    final static String ERROR_INCORRECT_EMAIL = "Incorrect \"e-mail\"";
    final static String SEMICOLON = ";";
    final static String COMMA = ",";

    @Test
    @Parameters(method = "parametersForCheckErrorsTest")
    public void checkErrorsTest(String name, String email, String password, String expectedMessages) {
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().clickOnButtonLogin();
        pageProvider.getLoginPage().clickOnButtonOrRegister();
        pageProvider.getLoginPage().enterTextIntoInputNameRegister(name);
        pageProvider.getLoginPage().enterTextIntoInputEmailRegister(email);
        pageProvider.getLoginPage().enterTextIntoInputPasswordRegister(password);
        pageProvider.getLoginPage().clickOnButtonRegisterConfirm();
        pageProvider.getLoginPage().checkErrorsMessages(expectedMessages);

    }

    public Object[][] parametersForCheckErrorsTest() {
        return new Object[][]{
                {"", "", "", ERROR_USERNAME_EMPTY + SEMICOLON + ERROR_EMAIL_EMPTY + SEMICOLON + ERROR_PASSWORD_EMPTY},
                {"%^^&", "%$%^", "^^&*", ERROR_USERNAME + SEMICOLON + ERROR_EMAIL + SEMICOLON + ERROR_PASSWORD},


        };


    }

}
