package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.externalUser.UserHomePO;

public class PageGenerator extends BasePage {
    public static HomePO getHomePage(WebDriver driver) {
        return new HomePO(driver);
    }

}
