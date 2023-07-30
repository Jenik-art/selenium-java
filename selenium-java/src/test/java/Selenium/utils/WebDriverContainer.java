package Selenium.utils;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.SAFARI;
import static com.codeborne.selenide.Browsers.FIREFOX;

public class WebDriverContainer {
     private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null) {
            try {
                initDriver();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        return driver;
    }

    private static void initDriver() throws MalformedURLException {
        Browser browser = Browser.getEnumByLabel(System.getProperty("browser",Browser.CHROME.getBrowserName()));

        DesiredCapabilities capabilities = new DesiredCapabilities();

        String platform = System.getProperty("platform", "mac");


        capabilities.setBrowserName(browser.getBrowserName());
        capabilities.setPlatform(Platform.MAC);


        driver = new RemoteWebDriver(new URL("http://192.168.100.3:4444/wd/hub"), capabilities);


//        driver = switch (browser){
//            case CHROME -> new ChromeDriver();
//            case SAFARI -> new SafariDriver();
//            case FIREFOX -> new FirefoxDriver();
//        };

        driver.manage().window().maximize();
   }

    public static void quiteDriver(){
        driver.quit();
        driver = null;
    }
}
