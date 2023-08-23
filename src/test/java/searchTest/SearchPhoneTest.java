package searchTest;

import baseTest.BaseTest;
import org.junit.Test;

import static data.TestData.PHONE_TEST_NAME;


public class SearchPhoneTest extends BaseTest {

    @Test
    public void searchPhone() {

        pageProvider.getLoginPage().loginWithValidCreds().hoverOnGadgets().hoverOnPhones().clickOnPhonesButton()
                .checkIsButtonOnlyMobilePhonesVisible().enterTextIntoInputSearch(PHONE_TEST_NAME).tapOnEnterKey()
                .checkIsSearchPhoneNameVisible();


    }


}
