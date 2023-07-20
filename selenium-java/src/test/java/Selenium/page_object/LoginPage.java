package Selenium.page_object;
import Selenium.locators.Locators;
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

    public static void attemptLogin(String email, String password) {
        getDriver().findElement(emailInput).sendKeys(email);
        getDriver().findElement(passwordInput).sendKeys(password);
        getDriver().findElement(loginButton).click();
    }

    public static String getErrorMessageText(WebDriver driver){
        return driver.findElement(errorMessage).getText();
    }
    public static String getSuccessMessageText(WebDriver driver){
        return driver.findElement(successMessage).getText();
    }

    public static void waitOfText() {
        String targetValue = " You are now logged in as Evgeny Art.";
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
        wait.until(ExpectedConditions.textToBe(LoginPage.getSuccessMessageLocator(), targetValue));

    }


}
