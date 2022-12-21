package secxndary_framework.page;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import secxndary_framework.model.Address;
import secxndary_framework.model.Comment;


public class OzByCartPage extends AbstractPage {

    @FindBy(xpath = "//input[@value='1']")
    WebElement inputChangeNumberOfGoods;

    @FindBy (xpath = "//span[text()='10+']")
    WebElement span10NumberOfGoods;

    @FindBy(xpath = "//input[@value='10']")
    WebElement inputEnterNumberOfGoods;

    @FindBy(xpath = "//*[@class='i-pseudolink__select']")
    WebElement selectChooseDeliveryCity;

    @FindBy(xpath = "//option[@value='1']")
    WebElement optionDeliveryCityMinsk;

    @FindBy(xpath = "//a[text() = 'Выберите способ доставки']")
    WebElement selectChooseDeliveryMethod;

    @FindBy(xpath = "//div[contains(text(), 'Курьером')]")
    WebElement optionCourierDeliveryMethod;

    @FindBy(xpath = "//*[@class='deal-form-main__input deal-form-main__input_popup i-input i-input_no-border-radius ']")
    WebElement inputDeliveryAddress;

    @FindBy(xpath = "//a[@class='i-context-box-list__control i-context-box-list__input_link']")
    WebElement buttonAddDeliveryAddress;

    @FindBy(xpath = "//*[@id = 'i-street']")
    WebElement inputFormAddressStreet;

    @FindBy(id = "i-house")
    WebElement inputFormAddressHouse;

    @FindBy(xpath = "//button[@class='i-button i-button_gray i-button_large']")
    WebElement buttonAddAddress;


    public OzByCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OzByCartPage enterNumberOfGoods(Comment numberOfGoods) {
        inputChangeNumberOfGoods.click();
        span10NumberOfGoods.click();
        waitForElementLocatedBy(driver, By.xpath("//input[@value='10']"));
        inputEnterNumberOfGoods.sendKeys(String.valueOf(numberOfGoods.getNumberOfGoods()));
        return this;
    }

    public Boolean checkIfNumberOfGoodsIsSent(Comment numberOfGoods) {
        String numberOfGoodsString = String.valueOf(numberOfGoods.getNumberOfGoods());
        try {
            driver.findElement(By.xpath("//input[@value='" + numberOfGoodsString + "']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public OzByCartPage chooseCourierDeliveryOption() {
        waitForElementLocatedBy(driver, By.xpath("//a[text() = 'Выберите способ доставки']"));
        selectChooseDeliveryMethod.click();
        waitForElementLocatedBy(driver, By.xpath("//*[@class='i-pseudolink__select']"));
        selectChooseDeliveryCity.click();
        optionDeliveryCityMinsk.click();
        waitForElementLocatedBy(driver, By.xpath("//div[contains(text(), 'Курьером')]"));
        optionCourierDeliveryMethod.click();
        return this;
    }

    public Boolean checkIfCourierDeliveryOptionShowsAddressInput() {
        try {
            waitForElementLocatedBy(driver, By.xpath("//*[@class='deal-form-main__input deal-form-main__input_popup i-input i-input_no-border-radius ']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public OzByCartPage addDeliveryAddress(Address address) {
        waitForElementLocatedBy(driver, By.xpath("//*[@class='deal-form-main__input deal-form-main__input_popup i-input i-input_no-border-radius ']"));
        inputDeliveryAddress.click();
        waitForElementLocatedBy(driver, By.xpath("//a[@class='i-context-box-list__control i-context-box-list__input_link']"));
        buttonAddDeliveryAddress.click();
        waitForElementLocatedBy(driver, By.xpath("//*[@id='i-street']"));
        inputFormAddressStreet.sendKeys(address.getStreet());
        inputFormAddressHouse.sendKeys(address.getHouse());
        buttonAddAddress.click();
        return this;
    }

    public Boolean checkIfAddressHasBeenAdded() {
        try {
            driver.findElement(By.xpath("//h2[@class='i-context-box-main__title i-h i-h_2']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    @Override
    public OzByCartPage waitForPageToLoad() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[@id='checkout-block-submit']")));
        return this;
    }
}
