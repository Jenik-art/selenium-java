package Selenium.tests;

import Selenium.page_object.*;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Selenium.utils.WebDriverContainer.getDriver;

public class CheckoutPageTest extends TestBase {
    private static String correctEmail = "ducklover@gmail.com";
    private static String incorrectEmail = "adsfdf@adsf.com";
    private static String correctPassword = "Test12345";
    private static String incorrectPassword = "adfadsf";
    @Feature("Cart")
    @Story("Success ordering")
    @Description("Test of success ordering Yellow Duck")
    @Test
    public static void makeSuccessOrderingTest()  {
        String expectedText = "Your order is successfully completed!";
        LoginPage.attemptLogin(correctEmail, correctPassword);
        HeaderMenu.goToRubberDuckPage(getDriver());
        CatalogPage.clickSortByNameBtn(getDriver());
        CatalogPage.goToYellowDuckSubgroupPage(getDriver());
        DuckPage.selectMediumSize();
        DuckPage.clickAddToCartBtn();
        DuckPage.waitAnimation();
        HeaderMenu.goToCartPage();
        CheckoutPage.clickConfirmOrderBtn();

        Assert.assertEquals(CheckoutPage.getCompleteOrderingMsg(),expectedText);

    }
}