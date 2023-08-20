package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhonesListPage extends ParentPage{
    public PhonesListPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@class='lf-text']/span[text()='only mobile phones']")
    private WebElement buttonOnlyMobilePhones;

    public void checkIsButtonOnlyMobilePhonesVisible() {
        checkElementDisplayed(buttonOnlyMobilePhones);
    }


}
