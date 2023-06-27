import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenPageTest {
    @Test
    public static void clickOnLink(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
    }
}
