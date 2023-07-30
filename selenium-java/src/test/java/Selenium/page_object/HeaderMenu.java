package Selenium.page_object;

import Selenium.locators.Locators;
import Selenium.utils.WebDriverContainer;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderMenu {
    private static By homePageBtn = Locators.getLocator("HeaderMenu.homePageBtn");
    private static By rubberDuckMenuItem = Locators.getLocator("HeaderMenu.rubberDuckMenuItem");
    private static By subcategoryMenuItem = Locators.getLocator("HeaderMenu.subcategoryMenuItem");
    private static By cartLink = Locators.getLocator("HeaderMenu.cartLink");
    private static By totalQuantityOfDucks = Locators.getLocator("HeaderMenu.totalQuantityOfDucks");
    @Step("Go to Rubber Duck page")
    public static void goToRubberDuckPage(WebDriver driver) {
        driver.findElement(rubberDuckMenuItem).click();
    }

    @Step("Go to Cart page")
    public static void goToCartPage() {
        WebDriverContainer.getDriver().findElement(cartLink).click();
    }

    public static By getQuantityOfPurchaseLocator() {
        return totalQuantityOfDucks;

    }

    public static String getQuantityOfPurchase() {
        String numberOfItems;
        numberOfItems = String.valueOf(WebDriverContainer.getDriver().findElement(totalQuantityOfDucks).getText());
        return numberOfItems;
    }
}
