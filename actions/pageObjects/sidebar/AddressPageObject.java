package pageObjects.sidebar;

import org.openqa.selenium.WebDriver;

public class AddressPageObject extends SidebarPageObject {
    private WebDriver driver;
    public AddressPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
