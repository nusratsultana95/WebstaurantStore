package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;
public class CommonAPI {
    public static WebDriver driver;

    /**
     * @param browser the browser you want to execute your test case
     * @param platform in the operating system you want to execute your test case
     * @param url the website url you want to launch
     * @return WebDriver Object
     */
    public static WebDriver setDriver(String browser, String platform,String url) {
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("disable-infobar");
        if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "..\\Generic\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver(chromeOptions);
        } else if(platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "..\\Generic\\src\\main\\resources\\chromedriver");
            driver = new ChromeDriver(chromeOptions);
        }
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    @Parameters({"platform", "url", "browser", "browserVersion"})
    @BeforeMethod
    public static WebDriver getDriver(String platform, String url, String browser,
                                       String browserVersion){
        driver=setDriver(browser, platform, url);
        driver.get(url);
        return driver;
    }

   @AfterMethod
   public void cleanUp(){
        driver.close();
        driver.quit();
   }
//    public void waitUntilClickable(String locator, int seconds) {
//        WebDriverWait webDriverWait = new WebDriverWait(driver, seconds);
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
//        driver.findElement(By.xpath(locator)).click();
//    }
//    public void waitUntilVisible(String locator,int seconds){
//        WebDriverWait wait2 = new WebDriverWait(driver,seconds);
//        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
//        driver.findElement(By.xpath(locator)).click();
//    }

    public void sleepFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
