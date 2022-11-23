package page_object.ozby.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object.ozby.page.OzByGoodsPage;
import page_object.ozby.page.OzByHomePage;

public class OzByTest {

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
    public void testGovna() throws InterruptedException {
        String login = "valdaitsevv@mail.ru";
        String password = "4cLMSR";

        new OzByHomePage(driver)
                .waitForMainPageToLoad()
                .openPage()
                .loginIntoAccount(login, password);
//                .openFirstGoodPage();

        Thread.sleep(50000);
//                .openFirstGoodPage();

//        new OzByGoodsPage(driver)
//                .waitForGoodsPageToLoad()
//                .clickOnLeaveCommentButton();
    }
}
