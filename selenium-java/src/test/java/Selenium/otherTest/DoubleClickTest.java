package Selenium.otherTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DoubleClickTest{
    @Test
    public static void checkWordIcon(){
        String expectImageSource = "http://www.pbclibrary.org/mousing/images/mess2.gif";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Actions builder = new Actions(driver);

        driver.get("http://www.pbclibrary.org/mousing/click3.htm");

        WebElement wordIcon = driver.findElement(By.name("icon2"));

        Actions dbClickWordIcon = new Actions(driver);

        dbClickWordIcon.doubleClick(wordIcon).perform();

        WebElement wordMessage = driver.findElement(By.name("mess2"));

        Assert.assertEquals(wordMessage.getAttribute("src"), expectImageSource);

        driver.quit();
    }

    @Test
    public static void checkPowerPointIcon(){
        String expectImageSource = "http://www.pbclibrary.org/mousing/images/mess3.gif";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Actions builder = new Actions(driver);

        driver.get("http://www.pbclibrary.org/mousing/click3.htm");

        WebElement wordIcon = driver.findElement(By.name("icon3"));

        Actions dbClickWordIcon = new Actions(driver);

        dbClickWordIcon.doubleClick(wordIcon).perform();

        WebElement wordMessage = driver.findElement(By.name("mess3"));

        Assert.assertEquals(wordMessage.getAttribute("src"), expectImageSource);

        driver.quit();

    }
}

