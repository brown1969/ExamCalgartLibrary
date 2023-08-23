package searchTest;

import baseTest.BaseTest;
import org.junit.Test;

import static data.TestData.PHONE_TEST_NAME;

public class AddToBookmarkListTest extends BaseTest {

    @Test
    public void addToBookmarkList() {
        pageProvider.getLoginPage().loginWithValidCreds().hoverOnGadgets().hoverOnPhones().clickOnPhonesButton()
                .checkIsButtonOnlyMobilePhonesVisible().enterTextIntoInputSearch(PHONE_TEST_NAME).tapOnEnterKey()
                .checkIsSearchPhoneNameVisible().clickOnSearchIPhone13().checkIsButtonAddToListVisible().clickOnButtonAddToList()
                .checkIsButtonMyListsVisible().clickOnButtonBookmarks().checkIsButtonAddToListVisible();


    }

}
