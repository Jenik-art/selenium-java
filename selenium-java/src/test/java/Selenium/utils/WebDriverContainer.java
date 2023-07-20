package Selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverContainer {
     private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            initDriver();
        }
        return driver;
    }

    private static void initDriver(){
        driver = new ChromeDriver();
//        Browser browser = Browser.getEnumByLabel(System.getProperty("browser",Browser.CHROME.getBrowserName()));
//
//
//        driver = switch (browser){
//            case CHROME ->  new ChromeDriver();
//            case SAFARI ->  new SafariDriver();
//            case FIREFOX -> new FirefoxDriver();
//        };

//        driver.manage().window().maximize();
    }

    public static void quiteDriver(){
        driver.quit();
        driver = null;
    }
}
