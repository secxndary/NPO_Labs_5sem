import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com/");


        // I Can Win
        WebElement textAreaInput = waitForElementLocatedBy(driver, By.id("postform-text"));
        WebElement selectPasteExpiration = waitForElementLocatedBy(driver, By.id("select2-postform-expiration-container"));
        WebElement inputPasteNameOrTitle = waitForElementLocatedBy(driver, By.id("postform-name"));
        WebElement buttonCreateNewPaste = waitForElementLocatedBy(driver, By.xpath("//button[text()='Create New Paste']"));
        WebElement liPasteExpiration10Minutes;
        // Bring It On
        WebElement selectSyntaxHighlighting = waitForElementLocatedBy(driver, By.id("select2-postform-format-container"));
        WebElement liSyntaxHighlightingBash;




        // I Can Win
//        textAreaInput.sendKeys("Hello from WebDriver");
//        selectPasteExpiration.click();
//        liPasteExpiration10Minutes = waitForElementLocatedBy(driver, By.xpath("//li[text()='10 Minutes']"));
//        liPasteExpiration10Minutes.click();
//        inputPasteNameOrTitle.sendKeys("helloweb");
//        buttonCreateNewPaste.click();


        // Bring It On
        textAreaInput.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                                            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                            "git push origin master --force\n");
        selectSyntaxHighlighting.click();
        liSyntaxHighlightingBash = waitForElementLocatedBy(driver, By.xpath("/html/body/span[2]/span/span[2]/ul/li[2]/ul/li[1]"));
        liSyntaxHighlightingBash.click();
        selectPasteExpiration.click();
        liPasteExpiration10Minutes = waitForElementLocatedBy(driver, By.xpath("//li[text()='10 Minutes']"));
        liPasteExpiration10Minutes.click();
        inputPasteNameOrTitle.sendKeys("how to gain dominance among developers");
        buttonCreateNewPaste.click();



        
        Thread.sleep(10000);
        driver.quit();
    }



    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
