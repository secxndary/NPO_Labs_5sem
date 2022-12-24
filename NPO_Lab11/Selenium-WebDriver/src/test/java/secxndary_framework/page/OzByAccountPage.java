package secxndary_framework.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OzByAccountPage extends AbstractPage {

    @FindBy(xpath = "//a[text()='Выйти']")
    WebElement linkLogoutFromAccount;


    public OzByAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.info("Opened AccountPage");
    }


    public OzByAccountPage clickLogOutButton() {
        linkLogoutFromAccount.click();
        logger.info("clickLogOutButton");
        return this;
    }


    @Override
    public OzByAccountPage waitForPageToLoad() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[text()='Выйти']")));
        return this;
    }
}
