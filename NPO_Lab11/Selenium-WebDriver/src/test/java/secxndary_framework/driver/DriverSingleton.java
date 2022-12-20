package secxndary_framework.driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton() { }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new FirefoxDriver();
                }
                case "ie": {
                    WebDriverManager.iedriver().setup();
                    driver = new FirefoxDriver();
                }
                case "opera": {
                    WebDriverManager.operadriver().setup();
                    driver = new FirefoxDriver();
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }


    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
