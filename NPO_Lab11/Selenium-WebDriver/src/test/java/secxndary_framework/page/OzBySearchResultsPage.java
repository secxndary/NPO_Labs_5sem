package secxndary_framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OzBySearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//a[text() = 'Нет в продаже']")
    WebElement optionNotForSale;


    public OzBySearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.info("Opened SearchResultsPage");
    }

    public Boolean checkIfSearchPageReturnsSearchResult() {
        try {
            driver.findElement(By.xpath("//p[text()='Токийский Гуль. Книга 1']"));
            logger.info("checkIfSearchPageReturnsSearchResult: true");
            return true;
        } catch (NoSuchElementException e) {
            logger.error("checkIfSearchPageReturnsSearchResult: NoSuchElementException");
            return false;
        }
    }

    public Boolean checkIfSearchFilterIsCorrect() {
        optionNotForSale.click();
        try {
            waitForElementLocatedBy(driver, By.xpath("//*[text()=' 26 товаров']"));
            logger.info("checkIfSearchFilterIsCorrect: true");
            return true;
        } catch (NoSuchElementException e) {
            logger.error("checkIfSearchFilterIsCorrect: NoSuchElementException");
            return false;
        }
    }
}
