package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class iPhone13Page extends ParentPage {
    public iPhone13Page(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[text()='add to list']")
    private WebElement buttonAddToList;

    @FindBy(xpath = "//span[text()='my lists']")
    private WebElement buttonMyLists;

    @FindBy(xpath = "//b[text()='Bookmarks']")
    private WebElement buttonBookmarks;

    public void checkIsButtonAddToListVisible() {
        webDriverWait15.until(ExpectedConditions.visibilityOf(buttonAddToList));
        checkElementDisplayed(buttonAddToList);
    }

    public void clickOnButtonAddToList() {
        clickOnElement(buttonAddToList);
    }


    public void checkIsButtonMyListsVisible() {
        webDriverWait15.until(ExpectedConditions.visibilityOf(buttonMyLists));
        checkElementDisplayed(buttonMyLists);
    }

    public void clickOnButtonMyLists() {
        clickOnElement(buttonMyLists);
    }


    public void clickOnButtonBookmarks() {
        clickOnElement(buttonBookmarks);
    }
}
