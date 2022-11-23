package page_object.ozby.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OzByHomePage {
    private static final String HOMEPAGE_URL = "https://oz.by";
    private final int WAIT_TIMEOUT_SECONDS = 10;
    private WebDriver driver;


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


    public OzByHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OzByHomePage waitForHomePageToLoad() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public OzByHomePage loginIntoAccount(String login, String password) {
        buttonOpenLoginForm.click();
        linkLoginUsingEmail.click();
        inputEmail.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonLoginIntoAccount.click();
        return this;
    }


    public OzByHomePage clickOrderCallLink() {
        try {
            linkOrderCall.click();
            waitForElementLocatedBy(driver, By.id("fullname"));
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex) {
            linkOrderCall.click();
            waitForElementLocatedBy(driver, By.id("fullname"));
        }
        return this;
    }

    public OzByHomePage enterOrderCallUserName(String userName) {
        inputOrderCallUserName.sendKeys(userName);
        return this;
    }

    public Boolean clickOrderCallButton() {
        try {
            driver.findElement(By.xpath("//div[@class='pp-window-user-i nohighlight pp-window-ok']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public OzByHomePage enterSearchText(String searchText) {
        inputSearch.sendKeys(searchText + Keys.ENTER);
        return this;
    }

    public OzByHomePage openCartPage() {
        try {
            waitForElementLocatedBy(driver, By.xpath("//u[text()='Корзина']"));
            linkToCart.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex) {
            waitForElementLocatedBy(driver, By.xpath("//u[text()='Корзина']"));
            linkToCart.click();
        }
        return this;
    }

    public OzByHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public OzByHomePage openFirstGoodPage() {
        waitForElementLocatedBy(driver, By.xpath("//ul[@id='goods_block_books_1']/li[@class='listatic li_1']"));
        firstGoodOnTheHomePage.click();
        return this;
    }

    public OzByHomePage openTextFeedbackPage() {
        try {
            linkOrderTextFeedback.click();
        }
        catch (org.openqa.selenium.StaleElementReferenceException ex) {
            linkOrderTextFeedback.click();
        }
        return this;
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
