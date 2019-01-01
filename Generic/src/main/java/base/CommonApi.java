package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CommonApi {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;

    @Parameters({/*"useCloudEnv","cloudEnvName", */"os", "os_version", "browserName", "browserVersion", "url"})
    @BeforeMethod
    public void setUp(/*@Optional("false") boolean useCloudEnv, @Optional("false") String cloudEnvName,*/
                     @Optional("windows") String os, @Optional("10") String os_version, @Optional("firefox") String browserName, @Optional("34")
                     String browserVersion, @Optional("www.google.com") String url) throws IOException {
        getLocalDriver(browserName, os);
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public WebDriver getLocalDriver(String browserName, String os) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\arifq\\eclipse-workspace\\webautomationpractice\\Generic\\Drivers\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/drivers/mac/chromedriver");
                driver = new ChromeDriver();
            }
        } else if (browserName.equalsIgnoreCase("firefox")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\arifq\\eclipse-workspace\\webautomationpractice\\Generic\\Drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/drivers/mac/geckodriver");
                driver = new FirefoxDriver();
            }
        } else if (browserName.equalsIgnoreCase("ie")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.ie.driver", "C:\\Users\\arifq\\eclipse-workspace\\webautomationpractice\\Generic\\Drivers\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            } else if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.ie.driver", "../Generic/drivers/mac/geckodriver");
                driver = new InternetExplorerDriver();
            }
        } else if (browserName.equalsIgnoreCase("edge")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.edge.driver", "C:\\Users\\arifq\\eclipse-workspace\\webautomationpractice\\Generic\\Drivers\\MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
            } else if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.edge.driver", "../Generic/drivers/mac/geckodriver");
                driver = new EdgeDriver();
            }
        }
        return driver;
    }


    @AfterMethod
    public void tearDown() {
        // driver.close();
        driver.quit();
    }


    public void clearField(WebElement webElement) {
        webElement.clear();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void typeOnWebElement(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    public void typeOnWebElementAndEnter(WebElement webElement, String value) {
        webElement.sendKeys(value, Keys.ENTER);
    }

}
