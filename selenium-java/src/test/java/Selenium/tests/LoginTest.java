package Selenium.tests;

import Selenium.page_object.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Selenium.utils.WebDriverContainer.getDriver;


public class LoginTest extends TestBase {

    private static String correctEmail = "ducklover@gmail.com";
    private static String incorrectEmail = "adsfdf@adsf.com";
    private static String correctPassword = "Test12345";
    private static String incorrectPassword = "adfadsf";




    @Test
    public static void loginWithValidCredentials() {
        String expectedMessage = "You are now logged in as Evgeny Art.";


        LoginPage.attemptLogin(correctEmail,correctPassword);

        Assert.assertEquals(LoginPage.getSuccessMessageText(getDriver()),expectedMessage);
    }

//    @Test
//    public static void loginWithInvalidEmail(){
//        String expectedMessage = "Wrong password or the account is disabled, or does not exist";
//
//        LoginPage.attemptLogin(getDriver(),incorrectEmail,correctPassword);
//
//        Assert.assertEquals(LoginPage.getErrorMessageText(getDriver()),expectedMessage);
//    }
//
//    @Test
//    public static void loginWithInvalidPassword(){
//        String expectedMessage = "Wrong password or the account is disabled, or does not exist";
//
//        LoginPage.attemptLogin(getDriver(),correctEmail,incorrectPassword);
//        Assert.assertEquals(LoginPage.getErrorMessageText(getDriver()),expectedMessage);
//    }

}
