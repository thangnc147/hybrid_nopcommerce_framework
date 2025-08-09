package pageObjects.externalUser.sidebar;

import org.openqa.selenium.WebDriver;

public class UserOrderPageObject extends UserSidebarPO {
    private WebDriver driver;
    public UserOrderPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
