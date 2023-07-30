package Selenium.page_object;

import Selenium.locators.Locators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Selenium.utils.WebDriverContainer.getDriver;

public class LoginPage {
    private static By emailInput = Locators.getLocator("LoginPage.emailInput");
    private static By passwordInput = Locators.getLocator("LoginPage.passwordInput");
    private static By loginButton = Locators.getLocator("LoginPage.loginButton");
    private static By successMessage = Locators.getLocator("LoginPage.successMessage");
    private static By errorMessage = Locators.getLocator("LoginPage.errorMessage");

    public static By getSuccessMessageLocator() {
        return successMessage;

    }
    @Step("Enter Email {0}")
    public static void putEmail(String email){
        getDriver().findElement(emailInput).sendKeys(email);
    }
    @Step("Enter password {0}")
    public static void putPassword(String password){
        getDriver().findElement(passwordInput).sendKeys(password);
    }
    @Step("Click login button")
    public static void clickLoginButton(){
        getDriver().findElement(loginButton).click();
    }
    @Step("Login attempt with email {0} and password {1}")
    public static void attemptLogin(String email, String password) {
        putEmail(email);
        putPassword(password);
        clickLoginButton();
    }

    public static String getErrorMessageText(WebDriver driver){
        return driver.findElement(errorMessage).getText();
    }
    public static String getSuccessMessageText(WebDriver driver){
        waitOfText();
        return driver.findElement(successMessage).getText();
    }

    public static void waitOfText() {
        String targetValue = "You are now logged in as Evgeny Art.";
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
        wait.until(ExpectedConditions.textToBe(LoginPage.getSuccessMessageLocator(), targetValue));

    }


}
