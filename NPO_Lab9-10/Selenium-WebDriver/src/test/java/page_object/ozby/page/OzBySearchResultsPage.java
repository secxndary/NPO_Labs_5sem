package page_object.ozby.page;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OzBySearchResultsPage {
    private final int WAIT_TIMEOUT_SECONDS = 10;
    private WebDriver driver;

    @FindBy(xpath = "//a[text() = 'Нет в продаже']")
    WebElement optionNotForSale;



    public OzBySearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean checkIfSearchPageReturnsSearchResult() {
        try {
            driver.findElement(By.xpath("//p[text()='Токийский Гуль. Книга 1']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean checkIfSearchFilterIsCorrect() {
        optionNotForSale.click();

        try {
            waitForElementLocatedBy(driver, By.xpath("//*[text()=' 29 товаров']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
