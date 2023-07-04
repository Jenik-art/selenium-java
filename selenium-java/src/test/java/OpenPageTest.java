import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class OpenPageTest {
    @Test
    public static void clickOnLink(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total links on the Wb Page: " + allLinks.size());
        allLinks.get(10).click();
        driver.quit();
    }
}
