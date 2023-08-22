package searchTest;

import baseTest.BaseTest;
import org.junit.Test;

import static data.TestData.PHONE_TEST_NAME;

public class AddToBookmarkListTest extends BaseTest {

    @Test
    public void addToBookmarkList() {
        pageProvider.getLoginPage().loginWithValidCreds();
        pageProvider.getLoginPage().hoverOnGadgets();
        pageProvider.getLoginPage().hoverOnPhones();
        pageProvider.getLoginPage().clickOnPhonesButton();
        pageProvider.getPhonesListPage().checkIsButtonOnlyMobilePhonesVisible();
        pageProvider.getPhonesListPage().enterTextIntoInputSearch(PHONE_TEST_NAME);
        pageProvider.getPhonesListPage().tapOnEnterKey();
        pageProvider.getIPhoneSearchPage().checkIsSearchPhoneNameVisible();
        pageProvider.getIPhoneSearchPage().clickOnSearchIPhone13();
        pageProvider.getIPhone13Page().checkIsButtonAddToListVisible();
        pageProvider.getIPhone13Page().clickOnButtonAddToList();
        pageProvider.getIPhone13Page().checkIsButtonMyListsVisible();
        pageProvider.getIPhone13Page().clickOnButtonBookmarks();
        pageProvider.getIPhone13Page().checkIsButtonAddToListVisible();
    }

}
