package page_object.ozby.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OzByGoodsPage {
    private final int WAIT_TIMEOUT_SECONDS = 25;
    private WebDriver driver;

    @FindBy(xpath = "//a[@class='b-comment-new__state-btn' and @onclick='Auth.open();return false;']")
    WebElement buttonLeaveComment;

    public OzByGoodsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OzByGoodsPage clickOnLeaveCommentButton () {
        buttonLeaveComment.click();
        return this;
    }

    public OzByGoodsPage waitForGoodsPageToLoad() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }
}
