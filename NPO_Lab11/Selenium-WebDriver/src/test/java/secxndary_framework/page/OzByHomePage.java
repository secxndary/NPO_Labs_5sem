package secxndary_framework.page;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import secxndary_framework.model.Comment;
import secxndary_framework.model.User;

public class OzByHomePage extends AbstractPage {

    @FindBy(xpath = "//ul[@id='goods_block_books_1']/li[@class='listatic li_1']")
    WebElement firstGoodOnTheHomePage;

    @FindBy(xpath = "//li[@class='top-panel__userbar__li ']/a[@class='top-panel__userbar__auth']")
    WebElement buttonOpenLoginForm;

    @FindBy(xpath = "//a[@id='loginFormLoginEmailLink']")
    WebElement linkLoginUsingEmail;

    @FindBy(xpath = "//form[@id='loginForm']/div/div/div/input[@class='i-input i-input_full-width i-popup__input']")
    WebElement inputEmail;

    @FindBy(xpath ="//form[@id='loginForm']/div/div/div/input[@class='i-input i-input_full-width i-input_with-padding i-popup__input']")
    WebElement inputPassword;

    @FindBy(xpath = "//form[@id='loginForm']/button[@value='login']")
    WebElement buttonLoginIntoAccount;

    @FindBy (xpath = "//a[@class='dark' and text()='Закажите звонок']")
    WebElement linkOrderCall;

    @FindBy(id = "fullname")
    WebElement inputOrderCallUserName;

    @FindBy(xpath = "//a[@class='dark border']")
    WebElement linkOrderTextFeedback;

    @FindBy(id = "top-s")
    WebElement inputSearch;

    @FindBy(xpath = "//u[text() = 'Корзина']")
    WebElement linkToCart;

    @FindBy(xpath = "//li[@class='top-panel__hnav__li']//a[text()='Электронные подарочные сертификаты']")
    WebElement linkToGiftCard;

    @FindBy(xpath = "//*[@data-aimnav-id='#mobile-userbar']")
    WebElement linkToAccountPage;



    public OzByHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.info("Opened HomePage");
    }


    public OzByHomePage loginIntoAccount(User user) {
        logger.info("loginIntoAccount: " + user.getUsername() + " / " + user.getPassword());
        buttonOpenLoginForm.click();
        linkLoginUsingEmail.click();
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        waitForElementLocatedBy(driver, By.xpath("//form[@id='loginForm']/button[@value='login']"));
        buttonLoginIntoAccount.click();
        return this;
    }

    public OzByHomePage clickOrderCallLink() {
        try {
            linkOrderCall.click();
            waitForElementLocatedBy(driver, By.id("fullname"));
            logger.info(("clickOrderCallLink"));
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex) {
            linkOrderCall.click();
            waitForElementLocatedBy(driver, By.id("fullname"));
            logger.info(("clickOrderCallLink"));
        }
        return this;
    }

    public OzByHomePage enterOrderCallUserName(User incorrectUserName) {
        inputOrderCallUserName.sendKeys(incorrectUserName.getIncorrectUsername());
        logger.info("enterOrderCallUserName: " + incorrectUserName.getIncorrectUsername());
        return this;
    }

    public Boolean clickOrderCallButton() {
        try {
            driver.findElement(By.xpath("//div[@class='pp-window-user-i nohighlight pp-window-ok']"));
            logger.info("clickOrderCallButton");
            return true;
        } catch (NoSuchElementException e) {
            logger.error("clickOrderCallButton: NoSuchElementException");
            return false;
        }
    }

    public OzByHomePage enterSearchText(Comment searchText) {
        inputSearch.sendKeys(searchText.getSearchText() + Keys.ENTER);
        logger.info("enterSearchText: " + searchText.getSearchText());
        return this;
    }

    public Boolean checkIfAccountIsLoggedOut() {
        try {
            driver.findElement(By.xpath("//li[@class='top-panel__userbar__li ']/a[@class='top-panel__userbar__auth']"));
            logger.info("checkIfAccountIsLoggedOut: true");
            return true;
        } catch (NoSuchElementException e) {
            logger.error("checkIfAccountIsLoggedOut: NoSuchElementException");
            return false;
        }
    }



    public OzByHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public OzByHomePage openCartPage() {
        try {
            waitForElementLocatedBy(driver, By.xpath("//div[@class='i-popup-login']"));
            waitForElementLocatedBy(driver, By.xpath("//u[text()='Корзина']"));
            linkToCart.click();
            logger.info("openCartPage");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex) {
            waitForElementLocatedBy(driver, By.xpath("//div[@class='i-popup-login']"));
            waitForElementLocatedBy(driver, By.xpath("//u[text()='Корзина']"));
            linkToCart.click();
            logger.info("openCartPage");
        }
        return this;
    }

    public OzByHomePage openFirstGoodPage() {
        waitForElementLocatedBy(driver, By.xpath("//ul[@id='goods_block_books_1']/li[@class='listatic li_1']"));
        firstGoodOnTheHomePage.click();
        logger.info("openFirstGoodPage");
        return this;
    }

    public OzByHomePage openTextFeedbackPage() {
        try {
            linkOrderTextFeedback.click();
            logger.info("openTextFeedbackPage");
        }
        catch (org.openqa.selenium.StaleElementReferenceException ex) {
            linkOrderTextFeedback.click();
            logger.info("openTextFeedbackPage");
        }
        return this;
    }

    public OzByHomePage openGiftCardPage() {
        try {
            linkToGiftCard.click();
            logger.info("openGiftCardPage");
        }
        catch (org.openqa.selenium.StaleElementReferenceException ex) {
            linkToGiftCard.click();
            logger.info("openGiftCardPage");
        }
        return this;
    }

    public OzByHomePage openAccountPage() {
        waitForElementLocatedBy(driver, By.xpath("//*[@data-aimnav-id='#mobile-userbar']"));
        linkToAccountPage.click();
        logger.info("openAccountPage");
        return this;
    }


    public OzByHomePage waitForHomePageToLoad() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }
}