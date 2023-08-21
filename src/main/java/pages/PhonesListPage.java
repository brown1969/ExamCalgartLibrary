package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhonesListPage extends ParentPage{
    public PhonesListPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@class='lf-text']/span[text()='only mobile phones']")
    private WebElement buttonOnlyMobilePhones;

    @FindBy(xpath = "//input[@name='search_']")
    private WebElement inputSearch;

    @FindBy(xpath = "//span[text()='Apple iPhone 13 128']")
    private WebElement searchPhoneName;

    public void checkIsButtonOnlyMobilePhonesVisible() {
        checkElementDisplayed(buttonOnlyMobilePhones);
    }

    public void enterTextIntoInputSearch(String phoneName) {
        enterTextIntoInput(inputSearch, phoneName);
    }

    public void checkIsSearchPhoneNameVisible() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(searchPhoneName));
        checkElementDisplayed(searchPhoneName);
    }

    public void tapOnEnterKey() {
        tapOnEnterKey(inputSearch);
    }



    public iPhoneSearchPage clickOnSearchIPhoneName() {
        tapOnEnterKey(inputSearch);
        return new iPhoneSearchPage(webDriver);
    }

}
