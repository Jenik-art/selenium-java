package Selenium.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

import static Selenium.utils.WebDriverContainer.getDriver;
import static Selenium.utils.WebDriverContainer.quiteDriver;

public class TestBase {
    protected static String url = "https://litecart.stqa.ru/en/";
    @BeforeTest
    public static void setup(){
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        getDriver().get(url);
    }
    @AfterTest
    public static void tearDown(){
        quiteDriver();
    }

}
