package secxndary_framework.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import secxndary_framework.creator.GiftCardCreator;
import secxndary_framework.model.Comment;
import secxndary_framework.model.GiftCard;


public class OzByGiftCardPage extends AbstractPage {

    private GiftCard giftCard = GiftCardCreator.getGiftCardWithAllData();
    private final String xPathLinkGiftCardVariablePrice = "//img[@alt='Электронный подарочный сертификат на сумму " +
            giftCard.getSingleGiftCardPrice() + " рублей']/../../../..";


    @FindBy(xpath = "//*[@class='b-product-control__button i-button i-button_large i-button_primary']")
    WebElement placeOrderButton;

    @FindBy(id = "giftCardsQuantitySelect")
    WebElement selectNumberOfGistCards;

    @FindBy(xpath = "//option[@value='10']")
    WebElement option10AndMoreGiftCards;

    @FindBy(id = "giftCardsQuantityInput")
    WebElement inputNumberOfGiftCards;

    @FindBy(xpath = "//p[text()='Для оформления заказа у вас должен быть указан номер телефона.']")
    WebElement pToClickAndCheckNumberOfGiftCards;

    @FindBy(xpath = "//a[@class='buygoods-button i-button i-button_full-width i-button_large i-button_primary i-popup__button']")
    WebElement buttonPayForOrder;



    public OzByGiftCardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.info("Opened GiftCardPage");
    }



    public OzByGiftCardPage selectGiftCard() {
        WebElement linkGiftCardVariablePrice = driver.findElement(By.xpath(xPathLinkGiftCardVariablePrice));
        linkGiftCardVariablePrice.click();
        logger.info("linkGiftCardVariablePrice");
        return this;
    }

    public OzByGiftCardPage placeAnOrder() {
        placeOrderButton.click();
        logger.info("placeAnOrder");
        return this;
    }

    public OzByGiftCardPage selectNumberOfGiftCards() {
        selectNumberOfGistCards.click();
        logger.info("selectNumberOfGiftCards");
        return this;
    }

    public OzByGiftCardPage enterNumberOfGiftCards(GiftCard giftCard) {
        option10AndMoreGiftCards.click();
        inputNumberOfGiftCards.click();
        inputNumberOfGiftCards.sendKeys(String.valueOf(giftCard.getNumberOfGiftCards()));
        pToClickAndCheckNumberOfGiftCards.click();
        logger.info("enterNumberOfGiftCards ", String.valueOf(giftCard.getNumberOfGiftCards()));
        logger.warn("Expected number of gift cards:  " + giftCard.getMaxTotalCostForGiftCards() +
                " / " + giftCard.getSingleGiftCardPrice() + " = " + giftCard.getMaxAmountOfGiftCards());
        return this;
    }

    public OzByGiftCardPage payForOrder() {
        buttonPayForOrder.click();
        logger.info("payForOrder");
        return this;
    }

    public int getActualNumberOfGiftCards() {
        int actualNumberOfGiftCards = Integer.parseInt(inputNumberOfGiftCards.getAttribute("value"));
        logger.warn("Actual number of gift cards:    " + actualNumberOfGiftCards);
        return actualNumberOfGiftCards;
    }



    public OzByGiftCardPage waitForGiftCardPageToLoad() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h1[text()='Электронный подарочный сертификат на сумму " +
                                giftCard.getSingleGiftCardPrice() + " рублей']")));
        return this;
    }

    @Override
    public OzByGiftCardPage waitForPageToLoad() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(xPathLinkGiftCardVariablePrice)));
        return this;
    }
}
