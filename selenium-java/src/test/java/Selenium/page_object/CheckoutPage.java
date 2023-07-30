package Selenium.page_object;

import Selenium.locators.Locators;
import Selenium.utils.WebDriverContainer;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CheckoutPage {
    private static By confirmOrder = Locators.getLocator("CheckoutPage.confirmOrder");
    private static By orderSuccessMsg = Locators.getLocator("CheckoutPage.orderSuccessMsg");
    @Step("Click confirm ordering button")
    public static void clickConfirmOrderBtn(){
        WebDriverContainer.getDriver().findElement(confirmOrder).click();
    }

    public static String getCompleteOrderingMsg(){
        return WebDriverContainer.getDriver().findElement(orderSuccessMsg).getText();
    }

}
