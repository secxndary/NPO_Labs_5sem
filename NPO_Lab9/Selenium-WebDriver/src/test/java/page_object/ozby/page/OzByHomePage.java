package page_object.ozby.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OzByHomePage {

    private static final String HOMEPAGE_URL = "https://oz.by";
    private final int WAIT_TIMEOUT_SECONDS = 25;
    private WebDriver driver;

//    @FindBy(xpath = "//ul[@id='goods_block_business_1']/li[@class='listatic li_1']")
    @FindBy(xpath = "//ul[@id='goods_block_books_1']/li[@class='listatic li_1']");
    WebElement firstGoodOnTheHomePage;

    @FindBy(xpath = "//li[@class='top-panel__userbar__li ']/a[@class='top-panel__userbar__auth']")
    WebElement buttonOpenLoginForm;

    @FindBy(xpath = "//a[@id='loginFormLoginEmailLink']")
    WebElement linkLoginUsingEmail;

    @FindBy(xpath = "//form[@id='loginForm']/div/div/div/input[@class='i-input i-input_full-width i-popup__input']")
    WebElement inputEmail;

    @FindBy(xpath ="//form[@id='loginForm']/div/div/div/input[@class='i-input i-input_full-width i-input_with-padding i-popup__input']")
    WebElement inputPassword;

    @FindBy(xpath = "//form[@id=\"loginForm\"]/button[@value='login']")
    WebElement buttonLoginIntoAcoount;

    public OzByHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OzByHomePage waitForMainPageToLoad() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public OzByHomePage loginIntoAccount(String login, String password) {
        buttonOpenLoginForm.click();
        linkLoginUsingEmail.click();
        inputEmail.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonLoginIntoAcoount.click();
        return this;
    }

    public OzByHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public OzByHomePage openFirstGoodPage() {
        waitForElementLocatedBy(driver, By.xpath("//ul[@id='goods_block_business_1']/li[@class='listatic li_1']"));
        firstGoodOnTheHomePage.click();
        return this;
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
