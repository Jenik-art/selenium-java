package Selenium.page_object;

import Selenium.locators.Locators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CatalogPage {
    private static By sortByNameBtn = Locators.getLocator("CatalogPage.sortByNameBtn");
    private static By yellowDuck = Locators.getLocator("CatalogPage.yellowDuck");
    @Step("Click sort by name button")
    public static void clickSortByNameBtn(WebDriver driver){
        driver.findElement(sortByNameBtn).click();
    }

    public static List<String> getListOfDucksName(WebDriver driver) {
        List<WebElement> listOfDucks = driver.findElements(By.cssSelector(".listing-wrapper.products a.link div.name"));

        List<String> ducks = listOfDucks.stream()
                .map(n -> n.getText())
                .collect(Collectors.toList());
        return ducks;

    }
    public static List<String> getSortedListOfDucksName(WebDriver driver) {
        List<WebElement> listOfDucks = driver.findElements(By.cssSelector(".listing-wrapper.products a.link div.name"));
        List<String> ducks = listOfDucks.stream()
                .map(n -> n.getText())
                .collect(Collectors.toList());
        List<String> sortedDucks = ducks;
        Collections.sort(sortedDucks);
        return ducks;

    }
    public static List<WebElement> getListOfDucks(WebDriver driver) {
        List<WebElement> listOfDucks = driver.findElements(By.cssSelector(".listing-wrapper.products a.link div.name"));
        return listOfDucks;
    }
    @Step("Go to Yellow Duck subgroup page")
    public static void goToYellowDuckSubgroupPage(WebDriver driver){
        driver.findElement(yellowDuck).click();
    }

}
