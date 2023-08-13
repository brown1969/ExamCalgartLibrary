package pages;

import elements.ElementsInPages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ParentPage extends ElementsInPages {


    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage(String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened " + url);
        } catch (Exception e) {
            logger.error("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
    }

}
