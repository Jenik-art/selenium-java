package Selenium.otherTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LiteCartPageTest {
    @Test
    public static void homePageTest(){
        String homePageTitleExpected = "Online Store | My Store";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");
        WebElement homeBtn = driver.findElement(By.cssSelector("[ title=\"Home\"]"));
        homeBtn.click();
        String homePageTitleActual = driver.getTitle();
        Assert.assertEquals(homePageTitleActual,homePageTitleExpected);
        driver.quit();
    }
    @Test
    public static void rubberDucksPageTest(){
        String rubberDucksPageTitleExpected = "Rubber Ducks | My Store";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        Actions builder = new Actions(driver);
        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksCategoryBtn = driver.findElement(By.cssSelector("[class ='category-1']>a[href]"));
        builder.moveToElement(rubberDucksCategoryBtn).perform();
        rubberDucksCategoryBtn.click();
        String rubberDucksPageTitleActual = driver.getTitle();
        Assert.assertEquals(rubberDucksPageTitleActual,rubberDucksPageTitleExpected);
        driver.quit();
    }

    @Test
    public static void subcategoryPageTest(){
        String subcategoryPageTitleExpected = "Subcategory | My Store";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        Actions builder = new Actions(driver);
        driver.get("https://litecart.stqa.ru/en/");
        WebElement rubberDucksCategoryBtn = driver.findElement(By.cssSelector("[class ='category-1']>a[href]"));
        WebElement subcategoryPageBtn = driver.findElement(By.cssSelector("[class ='category-2']>a[href]"));
        builder.moveToElement(rubberDucksCategoryBtn).perform();
        subcategoryPageBtn.click();
        String  subcategoryPageTitleActual = driver.getTitle();
        Assert.assertEquals(subcategoryPageTitleActual,subcategoryPageTitleExpected);
        driver.quit();
    }
}
