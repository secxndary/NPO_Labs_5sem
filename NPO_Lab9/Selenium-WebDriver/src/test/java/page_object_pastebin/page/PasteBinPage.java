package page_object_pastebin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

public class PasteBinPage {

    private final int WAIT_TIMEOUT_SECONDS = 25;
    private WebDriver driver;

    @FindBy(id = "postform-text")
    WebElement textAreaInput;

    @FindBy(id = "select2-postform-expiration-container")
    WebElement selectPasteExpiration;

    @FindBy(id = "postform-name")
    WebElement inputPasteNameOrTitle;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    WebElement buttonCreateNewPaste;

    @FindBy(id = "select2-postform-format-container")
    WebElement selectSyntaxHighlighting;

    WebElement liPasteExpiration10Minutes;

    WebElement liSyntaxHighlightingBash;


    public PasteBinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PasteBinPage waitForPastebinPageLoad() {
        driver.get("https://pastebin.com/");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public PasteBinPage () {
        return this;
    }

    public PasteBinPage () {
        return this;
    }

    public PasteBinPage () {
        return this;
    }

    public PasteBinPage () {
        return this;
    }

    public PasteBinPage () {
        return this;
    }
}
