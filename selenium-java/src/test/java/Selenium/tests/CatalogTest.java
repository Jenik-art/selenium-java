package Selenium.tests;

import Selenium.page_object.CatalogPage;
import Selenium.page_object.HeaderMenu;
import Selenium.page_object.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static Selenium.utils.WebDriverContainer.getDriver;

public class CatalogTest extends TestBase {
    private static String correctEmail = "ducklover@gmail.com";
    private static String incorrectEmail = "adsfdf@adsf.com";
    private static String correctPassword = "Test12345";
    private static String incorrectPassword = "adfadsf";

    @Test
    public static void sortByNameTest(){
        LoginPage.attemptLogin(correctEmail,correctPassword);
        HeaderMenu.goToRubberDuckPage(getDriver());
        List<String> expectedSorting = CatalogPage.getSortedListOfDucksName(getDriver());
        CatalogPage.clickSortByNameBtn(getDriver());
        List<String> actualSorting = CatalogPage.getListOfDucksName(getDriver());
        Assert.assertEquals(actualSorting,expectedSorting);
    }
    @Test
    public static void openYellowDuckPage(){
        String pageTitleExpected = "Yellow Duck | Subcategory | Rubber Ducks | My Store";
        LoginPage.attemptLogin(correctEmail,correctPassword);
        HeaderMenu.goToRubberDuckPage(getDriver());
        CatalogPage.clickSortByNameBtn(getDriver());
        CatalogPage.goToYellowDuckSubgroupPage(getDriver());
        String subcategoryPageTitleActual = getDriver().getTitle();

        Assert.assertEquals(subcategoryPageTitleActual,pageTitleExpected);
    }

}
