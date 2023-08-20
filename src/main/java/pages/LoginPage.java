package pages;

import libs.Util;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static data.TestData.*;

public class LoginPage extends ParentPage {

    @FindBy(xpath = "//em[text()='Log in']")
    private WebElement buttonLogIn;

    @FindBy(xpath = "//div[@class='signin-with signin-with-ek']")
    private WebElement buttonSignInWithEmail;

    @FindBy(xpath = "//div[@class='signin-with signin-with-reg']")
    private WebElement buttonOrRegister;

    @FindBy(xpath = "//input[@name='l_']")
    private WebElement inputUserNameOrEmail;

    @FindBy(xpath = "//input[@name='pw_']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement buttonSecondLogin;

    @FindBy(xpath = "//em[@title='Log out']")
    private WebElement buttonLogOut;

    @FindBy(xpath = "//a[@class='info-nick']")
    private WebElement buttonProfile;

    @FindBy(xpath = "//input[@name='p_[NikName]']")
    private WebElement inputNameRegister;

    @FindBy(xpath = "//input[@name='p_[EMail]']")
    private WebElement inputEmailRegister;

    @FindBy(xpath = "//input[@name='p_[PW0]']")
    private WebElement inputPasswordRegister;

    @FindBy(xpath = "//button[text()='Register']")
    private WebElement buttonRegisterConfirm;

    @FindBy(xpath = "//span[text()='Phones']")
    private WebElement buttonPhones;

    @FindBy(xpath = "//a[text()='Gadgets']")
//    @FindBy(xpath = "//a[@href='/k119.htm']")
    private WebElement hoverGadgets;

    final String listErrorsMessagesLocator = "//div[@class='ek-form-text']";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
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

    public void checkLogInButtonIsDisplayed() {
        checkElementDisplayed(buttonLogIn);
    }

    public void checkLogOutButtonIsDisplayed() {
        checkElementDisplayed(buttonLogOut);
    }

    public void checkUserProfileButtonIsDisplayed() {
        checkElementDisplayed(buttonProfile);
    }

    public void clickOnButtonOrRegister() {
        clickOnElement(buttonOrRegister);
    }

    public void enterTextIntoInputNameRegister(String name) {
        enterTextIntoInput(inputNameRegister, name);
    }

    public void enterTextIntoInputEmailRegister(String email) {
        enterTextIntoInput(inputEmailRegister, email);
    }

    public void enterTextIntoInputPasswordRegister(String password) {
        enterTextIntoInput(inputPasswordRegister, password);
    }

    public void clickOnButtonRegisterConfirm() {
        clickOnElement(buttonRegisterConfirm);
    }

    public void hoverOnPhones() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(buttonPhones));
        hoverOnElement(buttonPhones);
    }

    public void hoverOnGadgets() {
       webDriverWait15.until(ExpectedConditions.visibilityOf(hoverGadgets));
        hoverOnElement(hoverGadgets);
    }

    public void loginWithValidCreds() {
        openLoginPage();
        clickOnButtonLogin();
        clickOnButtonSignInWithEmail();
        enterTextIntoInputUserNameOrEmail(LOGIN_DEFAULT);
        enterTextIntoInputPassword(PASSWORD_DEFAULT);
        clickOnButtonSecondLogin();

    }

    public void loginWithInValidCreds() {
        openLoginPage();
        clickOnButtonLogin();
        clickOnButtonSignInWithEmail();
        enterTextIntoInputUserNameOrEmail(LOGIN_INVALID);
        enterTextIntoInputPassword(PASSWORD_INVALID);
        clickOnButtonSecondLogin();

    }


    public LoginPage checkErrorsMessages(String expectedMessages) {
        // error1;error2 -> [error1, error2]
        String[] errors = expectedMessages.split(";");
        // wait until number of errors will be expected
        webDriverWait10.until(
                ExpectedConditions.numberOfElementsToBe(
                        By.xpath(listErrorsMessagesLocator), errors.length));
        Util.waitABit(1); // wait until all errors will be visible
        Assert.assertEquals("Number of elements ", errors.length, getListOfErrors().size());

        ArrayList actualTextFromErrors = new ArrayList();
        for (WebElement element : getListOfErrors()) {
            actualTextFromErrors.add(element.getText());

        }

        SoftAssertions softAssertions = new SoftAssertions(); // об'єкт для накоплювальоних перевірок
        for (int i = 0; i < errors.length; i++) {

            softAssertions.assertThat(errors[i])
                    .as("Error " + i)
                    .isIn(actualTextFromErrors);

        }


        softAssertions.assertAll(); // перевірка всіх накоплювальних перевірок


        return this;
    }

    private List<WebElement> getListOfErrors() {
        return webDriver.findElements(By.xpath(listErrorsMessagesLocator));
    }


    public void hoverOnElement(WebElement element) {
        try {
            Actions actions = new Actions(webDriver);
            actions.moveToElement(element).perform();
            logger.info("Hover on element " + getElementName(element));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private String getElementName(WebElement element) {
        try {
            return element.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }


    public PhonesListPage clickOnPhonesButton() {
        clickOnElement(buttonPhones);
        return new PhonesListPage(webDriver);
    }


}
