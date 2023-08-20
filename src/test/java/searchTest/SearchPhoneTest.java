package searchTest;

import baseTest.BaseTest;
import org.junit.Test;

import static data.TestData.PHONE_TEST_NAME;


public class SearchPhoneTest extends BaseTest {

    @Test
    public void searchPhone() {

    pageProvider.getLoginPage().loginWithValidCreds();
    pageProvider.getLoginPage().hoverOnGadgets();
    pageProvider.getLoginPage().hoverOnPhones();
    pageProvider.getLoginPage().clickOnPhonesButton();
    pageProvider.getPhonesListPage().checkIsButtonOnlyMobilePhonesVisible();
    pageProvider.getPhonesListPage().enterTextIntoInputSearch(PHONE_TEST_NAME);
    pageProvider.getPhonesListPage().tapOnEnterKey();
    pageProvider.getPhonesListPage().checkIsSearchPhoneNameVisible();


    }


}
