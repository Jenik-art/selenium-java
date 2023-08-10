package Selenium.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static Selenium.utils.WebDriverContainer.getDriver;
import static Selenium.utils.WebDriverContainer.quiteDriver;


public class TestBase {
    protected static String url = "https://litecart.stqa.ru/en/";
    @BeforeMethod
    public static void setup(){
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        getDriver().get(url);
    }
    @AfterMethod
    public static void tearDown(){
        quiteDriver();
    }

}
