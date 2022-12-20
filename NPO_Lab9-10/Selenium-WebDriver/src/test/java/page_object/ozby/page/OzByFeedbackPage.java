package page_object.ozby.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OzByFeedbackPage {
    private final int WAIT_TIMEOUT_SECONDS = 10;
    private WebDriver driver;

    @FindBy(id = "inp-3")
    WebElement textAreaFeedbackMessage;

    @FindBy (xpath = "//button[@class='button-big']")
    WebElement buttonSendFeedback;

    public OzByFeedbackPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OzByFeedbackPage sendFeedbackMessage(String feedbackMessage) throws InterruptedException {
        textAreaFeedbackMessage.sendKeys(feedbackMessage);
        // это вынужденная заглушка, т.к. на сайте надо ввести капчу
        Thread.sleep(5000);
        buttonSendFeedback.click();
        return this;
    }

    public Boolean checkIfFeedbackMessageIsSent() {
        try {
            driver.findElement(By.xpath("//h1[text()='Сообщение отправлено. Спасибо!']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public OzByFeedbackPage waitForFeedbackPageToLoad() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id='inp-3']")));
        return this;
    }
}
