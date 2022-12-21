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

public class OzByGoodsPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='b-comment-new__state-btn']")
    WebElement buttonEnterComment;

    @FindBy(xpath = "//textarea[@class='b-comment-new__textarea b-comment-new__textarea_main' and @name='message']")
    WebElement textAreaCommentMessage;

    @FindBy(xpath = "//span[text()='Отправить отзыв']//..//..")
    WebElement buttonLeaveComment;


    @FindBy(xpath = "//button[@class='b-product-control__button i-button i-button_large i-button_orange addtocart-btn first-button']")
    WebElement buttonAddToCart;

    @FindBy(xpath = "//a[@class='b-product-control__button i-button i-button_info second-button']")
    WebElement linkToTheCart;



    public OzByGoodsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OzByGoodsPage clickOnLeaveCommentButton () {
        buttonEnterComment.click();
        return this;
    }

    public OzByGoodsPage enterComment (Comment commentText) {
        textAreaCommentMessage.sendKeys(commentText.getCommentText());
        return this;
    }

    public OzByGoodsPage sendComment() {
        buttonLeaveComment.click();
        return this;
    }

    public Boolean checkIfCommentIsSent(Comment commentText) {
        try {
            waitForElementLocatedBy(driver, By.xpath("//p[text()='" + commentText.getCommentText() + "']"));
            driver.findElement(By.xpath("//p[text()='" + commentText.getCommentText() + "']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public OzByGoodsPage openCartPage() {
        try {
            driver.findElement(By.xpath("//button[@class='b-product-control__button i-button i-button_large i-button_orange addtocart-btn first-button']"));
            buttonAddToCart.click();
            linkToTheCart.click();
        } catch (NoSuchElementException e) {
            waitForElementLocatedBy(driver, By.xpath("//a[@class='b-product-control__button i-button i-button_info second-button']"));
            linkToTheCart.click();
        }
        return this;
    }


    @Override
    public OzByGoodsPage waitForPageToLoad() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[@class='b-comment-new__state-btn']")));
        return this;
    }
}
