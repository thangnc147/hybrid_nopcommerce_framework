package pageObjects.sidebar;

import org.openqa.selenium.WebDriver;

public class RewardPointPageObject extends SidebarPageObject {
    private WebDriver driver;
    public RewardPointPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
