package secxndary_framework.test;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import secxndary_framework.creator.AddressCreator;
import secxndary_framework.creator.CommentCreator;
import secxndary_framework.model.Address;
import secxndary_framework.model.Comment;
import secxndary_framework.model.User;
import secxndary_framework.page.*;
import secxndary_framework.creator.UserCreator;


public class OzByTest extends CommonConditions{

    private User TEST_USER = UserCreator.withCredentialsFromProperty();
    private User TEST_INCORRECT_USER = UserCreator.withIncorrectUsername();
    private Address TEST_ADDRESS = AddressCreator.withStreetAndHouse();
    private Comment TEST_COMMENT = CommentCreator.getCommentWithAllData();


    @Ignore
    @Test
    public void LeaveComment_ShouldReturnError_WhenTheCommentTextLength_IsMoreThan300Symbols() {

        new OzByHomePage(driver)
                .waitForHomePageToLoad()
                .openPage()
                .loginIntoAccount(TEST_USER)
                .openFirstGoodPage();

        Boolean checkIfCommentIsSent = new OzByGoodsPage(driver)
                .waitForPageToLoad()
                .clickOnLeaveCommentButton()
                .enterComment(TEST_COMMENT)
                .sendComment()
                .checkIfCommentIsSent(TEST_COMMENT);

        Assert.assertFalse(checkIfCommentIsSent);
    }


    @Ignore
    @Test
    public void EnterNumberOfGoods_ShouldReturnError_WhenNumberOfGoods_IsMoreThan99() {

        new OzByHomePage(driver)
                .waitForHomePageToLoad()
                .openPage()
                .loginIntoAccount(TEST_USER)
                .openFirstGoodPage();

        new OzByGoodsPage(driver)
                .waitForPageToLoad()
                .openCartPage();

        Boolean checkIfNumberOfGoodsIsSent = new OzByCartPage(driver)
                .waitForPageToLoad()
                .enterNumberOfGoods(TEST_COMMENT)
                .checkIfNumberOfGoodsIsSent(TEST_COMMENT);

        Assert.assertFalse(checkIfNumberOfGoodsIsSent);
    }


    @Ignore
    @Test
    public void OrderCall_ShouldReturnError_WhenUserName_IsLongerThan100Symbols() {

        Boolean checkIfOrderCallSucceed = new OzByHomePage(driver)
                .waitForHomePageToLoad()
                .openPage()
                .loginIntoAccount(TEST_USER)
                .clickOrderCallLink()
                .enterOrderCallUserName(TEST_INCORRECT_USER)
                .clickOrderCallButton();

        Assert.assertFalse(checkIfOrderCallSucceed);
    }


    @Ignore
    @Test
    public void TextFeedbackForm_ShouldReturnError_WhenMessage_IsLongerThan100Symbols() throws InterruptedException {

        new OzByHomePage(driver)
                .waitForHomePageToLoad()
                .openPage()
                .loginIntoAccount(TEST_USER)
                .openTextFeedbackPage();

        OzByFeedbackPage ozByFeedbackPage = new OzByFeedbackPage(driver)
                .waitForPageToLoad()
                .sendFeedbackMessage(TEST_COMMENT);
        Thread.sleep(5000);
        Boolean checkIfFeedbackMessageIsSent = ozByFeedbackPage.checkIfFeedbackMessageIsSent();

        Assert.assertFalse(checkIfFeedbackMessageIsSent);
    }


    @Ignore
    @Test
    public void SearchPage_ShouldShowSearchResults() {

        new OzByHomePage(driver)
                .waitForHomePageToLoad()
                .openPage()
                .enterSearchText(TEST_COMMENT);

        Boolean checkIfSearchPageReturnsSearchResult =
                new OzBySearchResultsPage(driver)
                .checkIfSearchPageReturnsSearchResult();

        Assert.assertTrue(checkIfSearchPageReturnsSearchResult);
    }


    @Ignore
    @Test
    public void SearchFilter_ShouldShowFilterResults() {

        new OzByHomePage(driver)
                .waitForHomePageToLoad()
                .openPage()
                .enterSearchText(TEST_COMMENT);

        Boolean checkIfSearchFilterIsCorrect =
                new OzBySearchResultsPage(driver)
                        .checkIfSearchFilterIsCorrect();

        Assert.assertTrue(checkIfSearchFilterIsCorrect);
    }


    @Ignore
    @Test
    public void CourierDelivery_ShouldShowAddressInput() {

        new OzByHomePage(driver)
                .waitForHomePageToLoad()
                .openPage()
                .loginIntoAccount(TEST_USER)
                .openCartPage();

        Boolean checkIfCourierDeliveryOptionShowsAddressInput = new OzByCartPage(driver)
                .waitForPageToLoad()
                .chooseCourierDeliveryOption()
                .checkIfCourierDeliveryOptionShowsAddressInput();

        Assert.assertTrue(checkIfCourierDeliveryOptionShowsAddressInput);
    }


//    @Ignore
    @Test
    public void AddressAdding_ShouldReturnError_WhenAddressIsNonExistent() {

        new OzByHomePage(driver)
                .waitForHomePageToLoad()
                .openPage()
                .loginIntoAccount(TEST_USER)
                .openCartPage();

        Boolean checkIfAddressHasBeenAdded = new OzByCartPage(driver)
                .waitForPageToLoad()
                .chooseCourierDeliveryOption()
                .addDeliveryAddress(TEST_ADDRESS)
                .checkIfAddressHasBeenAdded();

        Assert.assertFalse(checkIfAddressHasBeenAdded);
    }
}
