package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class iPhone13Page extends ParentPage{
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
        checkElementDisplayed(buttonAddToList);
    }

    public void clickOnButtonAddToList() {
        clickOnElement(buttonAddToList);
    }


    public void checkIsButtonMyListsVisible() {
        checkElementDisplayed(buttonMyLists);
    }

    public void clickOnButtonMyLists() {
        clickOnElement(buttonMyLists);
    }


    public void clickOnButtonBookmarks() {
        clickOnElement(buttonBookmarks);
    }
}
