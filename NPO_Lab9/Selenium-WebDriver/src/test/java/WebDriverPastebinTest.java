import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import waits.CustomConditions;

import java.util.List;


public class WebDriverPastebinTest {

    private WebDriver driver;


    @BeforeMethod (alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        new WebDriverWait(driver, 10).until(CustomConditions.jQueryAJAXsCompleted());
    }


    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
        driver = null;
    }


    @Test
    public void ICanWinTest() {
        WebElement textAreaInput = waitForElementLocatedBy(driver, By.id("postform-text"));
        WebElement selectPasteExpiration = waitForElementLocatedBy(driver, By.id("select2-postform-expiration-container"));
        WebElement inputPasteNameOrTitle = waitForElementLocatedBy(driver, By.id("postform-name"));
        WebElement buttonCreateNewPaste = waitForElementLocatedBy(driver, By.xpath("//button[text()='Create New Paste']"));
        WebElement liPasteExpiration10Minutes;


        textAreaInput.sendKeys("Hello from WebDriver");
        selectPasteExpiration.click();
        liPasteExpiration10Minutes = waitForElementLocatedBy(driver, By.xpath("//li[text()='10 Minutes']"));
        liPasteExpiration10Minutes.click();
        inputPasteNameOrTitle.sendKeys("helloweb");
        buttonCreateNewPaste.click();

        // ASSERT
        Assert.assertTrue(true);
    }



    @Test
    public void BringItOnTest() {
        WebElement textAreaInput = waitForElementLocatedBy(driver, By.id("postform-text"));
        WebElement selectPasteExpiration = waitForElementLocatedBy(driver, By.id("select2-postform-expiration-container"));
        WebElement inputPasteNameOrTitle = waitForElementLocatedBy(driver, By.id("postform-name"));
        WebElement buttonCreateNewPaste = waitForElementLocatedBy(driver, By.xpath("//button[text()='Create New Paste']"));
        WebElement liPasteExpiration10Minutes;
        WebElement selectSyntaxHighlighting = waitForElementLocatedBy(driver, By.id("select2-postform-format-container"));
        List<WebElement> liSyntaxHighlightingBash;


        textAreaInput.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                                            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                            "git push origin master --force\n");
        selectSyntaxHighlighting.click();
        liSyntaxHighlightingBash = driver.findElements(By.xpath("//li[text()='Bash']"));
        liSyntaxHighlightingBash.get(0).click();
        selectPasteExpiration.click();
        liPasteExpiration10Minutes = waitForElementLocatedBy(driver, By.xpath("//li[text()='10 Minutes']"));
        liPasteExpiration10Minutes.click();
        inputPasteNameOrTitle.sendKeys("how to gain dominance among developers");
        buttonCreateNewPaste.click();


        // ASSERT
        Assert.assertTrue(true);
    }



    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
