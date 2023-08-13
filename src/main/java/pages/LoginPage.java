package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = "//em[text()='Log in']")
    private WebElement buttonLogIn;

    @FindBy(xpath = "//div[@class='signin-with signin-with-ek']")
    private WebElement buttonSignInWithEmail;

    @FindBy(xpath = "//div[@class='signin-with signin-with-reg']")
    private WebElement buttonRegistration;

    @FindBy(xpath = "//input[@name='l_']")
    private WebElement inputUserNameOrEmail;

    @FindBy(xpath = "//input[@name='pw_']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement buttonSecondLogin;

    @FindBy(xpath = "//em[@title='Log out']")
    private WebElement buttonLogOut;


    public LoginPage(WebDriver webDriver) { super(webDriver);
    }

    public void openLoginPage() {
        openPage(BASE_URL);
    }

    public void clickOnButtonLogin() {
        clickOnElement(buttonLogIn);
    }

    public void clickOnButtonSecondLogin() {
        clickOnElement(buttonSecondLogin);
    }

    public void clickOnButtonSignInWithEmail() {
        clickOnElement(buttonSignInWithEmail);
    }

        public void enterTextIntoInputUserNameOrEmail(String userName) {
        enterTextIntoInput(inputUserNameOrEmail, userName);
    }

    public void enterTextIntoInputPassword(String password) {
        enterTextIntoInput(inputPassword, password);
    }

    public void checkLogInButtonIsNotDisplayed() {
        checkElementNotDisplayed(buttonLogIn);
    }

    public void checkLogOutButtonIsDisplayed() {
        checkElementDisplayed(buttonLogOut);
    }


}
