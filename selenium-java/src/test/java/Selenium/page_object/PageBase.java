package Selenium.page_object;

import static Selenium.utils.WebDriverContainer.getDriver;

public class PageBase {

    protected boolean hasLoaded(String title){
        return getDriver().getTitle().equals(title);
    }
}
