package pageobject_model.page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class GoogleCloudAbstractPage {
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected WebDriver driver;
    protected abstract GoogleCloudAbstractPage openPage();

    protected GoogleCloudAbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
