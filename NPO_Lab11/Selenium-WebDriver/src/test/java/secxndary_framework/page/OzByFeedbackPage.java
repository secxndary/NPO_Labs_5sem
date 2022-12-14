package secxndary_framework.page;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import secxndary_framework.model.Comment;


public class OzByFeedbackPage extends AbstractPage {

    @FindBy(id = "inp-3")
    WebElement textAreaFeedbackMessage;

    @FindBy (xpath = "//button[@class='button-big']")
    WebElement buttonSendFeedback;

    public OzByFeedbackPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OzByFeedbackPage sendFeedbackMessage(Comment feedbackMessage) throws InterruptedException {
        textAreaFeedbackMessage.sendKeys(feedbackMessage.getFeedbackText());
        // это вынужденная заглушка, т.к. на сайте надо ввести капчу
        Thread.sleep(5000);
        buttonSendFeedback.click();
        logger.info("sendFeedbackMessage: " + feedbackMessage.getFeedbackText());
        return this;
    }

    public Boolean checkIfFeedbackMessageIsSent() {
        try {
            driver.findElement(By.xpath("//h1[text()='Сообщение отправлено. Спасибо!']"));
            logger.info("checkIfFeedbackMessageIsSent: true");
            return true;
        } catch (NoSuchElementException e) {
            logger.error("checkIfFeedbackMessageIsSent: NoSuchElementException");
            return false;
        }
    }


    @Override
    public OzByFeedbackPage waitForPageToLoad() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id='inp-3']")));
        return this;
    }
}
