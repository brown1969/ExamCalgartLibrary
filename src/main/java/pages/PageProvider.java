package pages;

import org.openqa.selenium.WebDriver;

public class PageProvider {
    WebDriver webDriver;

    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(webDriver);
    }

    public PhonesListPage getPhonesListPage() {
        return new PhonesListPage(webDriver);
    }

    public iPhoneSearchPage getIPhoneSearchPage() {
        return new iPhoneSearchPage(webDriver);
    }

    public iPhone13Page getIPhone13Page() {
        return new iPhone13Page(webDriver);
    }

}
