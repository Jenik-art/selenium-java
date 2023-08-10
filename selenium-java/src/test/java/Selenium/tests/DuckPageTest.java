package Selenium.tests;

import Selenium.page_object.*;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Selenium.utils.WebDriverContainer.getDriver;

public class DuckPageTest extends TestBase {
    private static String correctEmail = "ducklover@gmail.com";
    private static String incorrectEmail = "adsfdf@adsf.com";
    private static String correctPassword = "Test12345";
    private static String incorrectPassword = "adfadsf";
    @Feature("Adding items to cart")
    @Story("Adding Duct to cart")
    @Description("Test of adding Duck to Cart")
    @Test
    public static void addDuckToCartTest(){
        String expectedAmount = "1";
        LoginPage.attemptLogin(correctEmail,correctPassword);
        HeaderMenu.goToRubberDuckPage(getDriver());
        CatalogPage.clickSortByNameBtn(getDriver());
        CatalogPage.goToYellowDuckSubgroupPage(getDriver());
        DuckPage.selectMediumSize();
        DuckPage.clickAddToCartBtn();
        DuckPage.waitAnimation();

        Assert.assertEquals(HeaderMenu.getQuantityOfPurchase(), expectedAmount);

    }
}
