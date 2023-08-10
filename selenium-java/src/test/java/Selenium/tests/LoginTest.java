package Selenium.tests;

import Selenium.page_object.LoginPage;
import Selenium.utils.ScreenshotListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Selenium.utils.WebDriverContainer.getDriver;
//@Listeners(ReportPortalTestNGListener.class)
@Listeners(ScreenshotListener.class)
public class LoginTest extends TestBase {

    private static String correctEmail = "ducklover@gmail.com";
    private static String incorrectEmail = "adsfdf@adsf.com";
    private static String correctPassword = "Test12345";
    private static String incorrectPassword = "adfadsf";



    @Feature("Login")
    @Story("Valid credentials")
    @Description("Login test with valid credentials")
    @Test
    public static void loginWithValidCredentials() {
        String expectedMessage = "You are now logged in as Evgeny Art.";

        LoginPage.attemptLogin(correctEmail,correctPassword);

        Assert.assertEquals(LoginPage.getSuccessMessageText(getDriver()),expectedMessage);
    }
    @Feature("Login")
    @Story("Wrong email")
    @Description("Login test with wrong email")
    @Test
    public static void loginWithInvalidEmail(){
        String expectedMessage = "Wrong password or the account is disabled, or does not exist";

        LoginPage.attemptLogin(incorrectEmail,correctPassword);

        Assert.assertEquals(LoginPage.getErrorMessageText(getDriver()),expectedMessage);
    }
    @Feature("Login")
    @Story("Wrong password")
    @Description("Login test with wrong password")
    @Test
    public static void loginWithInvalidPassword(){
        String expectedMessage = "Wrong password or the account is disabled, or does not exist";

        LoginPage.attemptLogin(correctEmail,incorrectPassword);
        Assert.assertEquals(LoginPage.getErrorMessageText(getDriver()),expectedMessage);
    }

    @Feature("Login")
    @Story("No password")
    @Description("Failed Login test with no password")
    @Test
    public static void loginWithoutPassword() {
        String expectedMessage = "Wrong password or the account is disabled, or does not exist";

        LoginPage.putEmail(correctEmail);
        LoginPage.clickLoginButton();
        Assert.assertEquals(LoginPage.getErrorMessageText(getDriver()), expectedMessage);
    }

}
