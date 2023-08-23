package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementsInPages {
    protected Logger logger = Logger.getLogger(getClass());
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait10, webDriverWait15;

    public ElementsInPages(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this); // this means that all elements will be initialized in this class by FindBy annotation

        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    public void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputted into input");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }


    public void clickOnElement(WebElement element) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Element was clicked " + getElementName(element));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {

            boolean state = element.isDisplayed();
            if (state) {
                logger.info("Element is displayed " + getElementName(element));
            } else {
                logger.info("Element is not displayed " + getElementName(element));
            }
            return state;
        } catch (Exception e) {
            logger.info("Element is not displayed");
            return false;
        }
    }

    public void checkElementDisplayed(WebElement element) {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(element));
    }

    public void checkElementNotDisplayed(WebElement element) {
        Assert.assertFalse("Element is displayed", isElementDisplayed(element));

    }

    protected void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }

    public void tapOnEnterKey(WebElement element) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(Keys.ENTER);
            logger.info("Enter key was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
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


}
