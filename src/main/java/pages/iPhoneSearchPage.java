package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class iPhoneSearchPage extends ParentPage {
    public iPhoneSearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[text()='Apple iPhone 13 128']")
    private WebElement searchPhoneName;


    public void checkIsSearchPhoneNameVisible() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(searchPhoneName));
        checkElementDisplayed(searchPhoneName);
    }


    public iPhone13Page clickOnSearchIPhone13() {
        clickOnElement(searchPhoneName);
        return new iPhone13Page(webDriver);
    }


}
