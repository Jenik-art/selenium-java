package Selenium.page_object;

import Selenium.locators.Locators;
import Selenium.utils.WebDriverContainer;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DuckPage {
    private static By selectSize = Locators.getLocator("DuckPage.selectSize");
    private static By duckQuantity = Locators.getLocator("DuckPage.duckQuantity");
    private static By addToCartBtn = Locators.getLocator("DuckPage.addToCartBtn");
    private static By duckSizeMedium = Locators.getLocator("DuckPage.duckSizeMedium");

    @Step("Select Medium size")
    public static void selectMediumSize(){
        Select se = new Select(WebDriverContainer.getDriver().findElement(selectSize));
        se.selectByValue("Medium");
    }
    @Step("Click add to Cart button")
    public static void clickAddToCartBtn(){
        WebDriverContainer.getDriver().findElement(addToCartBtn).click();
    }


    public static void waitAnimation() {
        String targetValue = "1";
        WebDriverWait wait = new WebDriverWait(WebDriverContainer.getDriver(), Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
        wait.until(ExpectedConditions.textToBe(HeaderMenu.getQuantityOfPurchaseLocator(), targetValue));

    }


}
