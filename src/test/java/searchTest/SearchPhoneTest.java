package searchTest;

import baseTest.BaseTest;
import org.junit.Test;



public class SearchPhoneTest extends BaseTest {

    @Test
    public void searchPhone() {

    pageProvider.getLoginPage().loginWithValidCreds();
    pageProvider.getLoginPage().hoverOnGadgets();
    pageProvider.getLoginPage().hoverOnPhones();
    pageProvider.getLoginPage().clickOnPhonesButton();
    pageProvider.getPhonesListPage().checkIsButtonOnlyMobilePhonesVisible();


    }


}
