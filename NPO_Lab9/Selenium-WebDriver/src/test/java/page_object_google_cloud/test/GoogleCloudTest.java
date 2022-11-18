package page_object_google_cloud.test;

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
import page_object_google_cloud.page.GoogleCloudHomePage;
import page_object_google_cloud.page.GoogleCloudPricingCalculatorPage;
import page_object_google_cloud.page.GoogleCloudSearchResultPage;

public class GoogleCloudTest {

    private WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
        driver = null;
    }


    @Test
    public void GoogleCloudPricingCalculatorTest() throws InterruptedException {
        String searchText = "Google Cloud Platform Pricing Calculator";
        String actualSearchResult =
                new GoogleCloudHomePage(driver)
                .openPage()
                .searchFromHomePage(searchText);

        new GoogleCloudSearchResultPage(driver).selectSearchResult();

        GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage =
                new GoogleCloudPricingCalculatorPage(driver)
                .waitForCalculatorPageToLoad()
                .chooseNumberOfInstances(4)
                .chooseWhatAreInstancesFor("")
                .chooseSeries();

        Thread.sleep(5000);

        googleCloudPricingCalculatorPage
                .chooseMachineType()
                .addGPUs()
                .addSSD()
                .chooseDatacenterLocation()
                .chooseCommittedUsage()
                .addToEstimate();

        Thread.sleep(5000);
        // refactor assert
        Assert.assertEquals(searchText, actualSearchResult);
    }





//    @Test
//    public void GoogleCloudStubTest() throws InterruptedException {
//        WebElement buttonSearch = waitForElementLocatedBy(driver, By.xpath("//div[@class='devsite-search-container']"));
//        WebElement inputSearch = waitForElementLocatedBy(driver, By.xpath("//input[@aria-label='Search']"));
//
//
//        buttonSearch.click();
//        inputSearch.sendKeys("Google Cloud Platform Pricing Calculator" + Keys.ENTER);
//

        // переход на страницу результатов поиска
//        WebDriverWait waitForPricingCalculatorPage = new WebDriverWait(driver, 10);
//        waitForPricingCalculatorPage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Google Cloud Pricing Calculator']")));
//        WebElement linkToTheCalculatorPage = waitForElementLocatedBy(driver, By.xpath("//b[text()='Google Cloud Pricing Calculator']"));
//        linkToTheCalculatorPage.click();
//
//
//        // переход на страницу с выбором параметров облачного сервера
//        WebDriverWait waitForCalculatorTest = new WebDriverWait(driver, 10);
//        waitForCalculatorTest.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[contains(@name,'goog_')]")));
//        WebElement calculatorFrame = waitForElementLocatedBy(driver, By.xpath("//iframe[contains(@name,'goog_')]"));
//        driver.switchTo().frame(calculatorFrame);
//        driver.switchTo().frame("myFrame");
//
//
//
//        WebElement inputNumberOfInstances = waitForElementLocatedBy(driver, By.xpath("//input[@ng-model='listingCtrl.computeServer.quantity']"));
//        inputNumberOfInstances.click();
//        inputNumberOfInstances.sendKeys("4");
//
//        WebElement inputWhatAreInstancesFor = waitForElementLocatedBy(driver, By.xpath("//input[@ng-model='listingCtrl.computeServer.label']"));
//        inputWhatAreInstancesFor.click();
//        inputWhatAreInstancesFor.sendKeys("");
//
//        WebElement selectSeries = waitForElementLocatedBy(driver, By.xpath("//md-select[@ng-model='listingCtrl.computeServer.series']"));
//        WebElement optionN1Series = waitForElementLocatedBy(driver, By.xpath("//md-option[@value='n1']"));
//        selectSeries.click();
//        optionN1Series.click();
//
//        WebElement selectMachineType = waitForElementLocatedBy(driver, By.xpath("//md-select[@ng-model='listingCtrl.computeServer.instance']"));
//        WebElement optionN2Standard8Machine = waitForElementLocatedBy(driver, By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']"));
//        selectMachineType.click();
//        optionN2Standard8Machine.click();
//
//        WebElement checkBoxAddGPUs = waitForElementLocatedBy(driver, By.xpath("//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']"));
//        checkBoxAddGPUs.click();
//        WebElement selectGPUType = waitForElementLocatedBy(driver, By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuType']"));
//        selectGPUType.click();
//        WebElement optionGPUTeslaV100 = waitForElementLocatedBy(driver, By.xpath("//md-option[@value='NVIDIA_TESLA_V100']"));
//        optionGPUTeslaV100.click();
//
//        WebElement selectLocalSSD = waitForElementLocatedBy(driver, By.xpath("//md-select[@ng-model='listingCtrl.computeServer.ssd']"));
//        selectLocalSSD.click();
//
//        WebElement option2x375GBLocalSSD = waitForElementLocatedBy(driver, By.xpath("//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer' and @value='2']"));
//        option2x375GBLocalSSD.click();
//
//        WebElement selectDatacenterLocation = waitForElementLocatedBy(driver, By.xpath("//md-select[@ng-model='listingCtrl.computeServer.location']"));
//        selectDatacenterLocation.click();
//        WebElement optionFrankfurtLocation = waitForElementLocatedBy(driver, By.xpath("//md-option[@ng-repeat='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer' and @value='europe-west3']"));
//        optionFrankfurtLocation.click();
//
//        WebElement selectCommittedUsage = waitForElementLocatedBy(driver, By.xpath("//md-select[@ng-model='listingCtrl.computeServer.cud']"));
//        selectCommittedUsage.click();
//        WebElement option1YearUsage = waitForElementLocatedBy(driver, By.xpath("//div[@class='md-select-menu-container md-active md-clickable']/md-select-menu/md-content/md-option[@value='1']"));
//        option1YearUsage.click();
//
//        WebElement buttonAddToEstimate = waitForElementLocatedBy(driver, By.xpath("//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']"));
//        buttonAddToEstimate.click();
//
//
//
//
//        WebElement buttonEmailEstimate = waitForElementLocatedBy(driver, By.id("email_quote"));
//        buttonEmailEstimate.click();
//
//
//        driver.get("https://yopmail.com/en/");
//        new WebDriverWait(driver, 10);
//
//        WebElement inputEmail = waitForElementLocatedBy(driver, By.xpath("//input[@ng-model='emailQuote.user.email']"));
//        inputEmail.sendKeys("");
//
//        Thread.sleep(5000);
//        Assert.assertTrue(true);
//    }


    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
