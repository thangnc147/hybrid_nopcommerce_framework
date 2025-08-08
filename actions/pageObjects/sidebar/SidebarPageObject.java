package pageObjects.sidebar;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.SidebarPageUI;

public class SidebarPageObject extends BasePage {
    private WebDriver driver;

    public SidebarPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RewardPointPageObject openRewardPointPage() {
        waitForElementClickable(driver, SidebarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, SidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getRewardPointPage(driver);
    }

    public AddressPageObject openAddressPage() {
        waitForElementClickable(driver, SidebarPageUI.ADDRESS_LINK);
        clickToElement(driver, SidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getAddressPage(driver);
    }

    public OrderPageObject openOrderPage() {
        waitForElementClickable(driver, SidebarPageUI.ORDER_LINK);
        clickToElement(driver, SidebarPageUI.ORDER_LINK);
        return PageGenerator.getOrderPage(driver);
    }

    public CustomerInfoPageObject openCustomerInfoPage() {
        waitForElementClickable(driver, SidebarPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, SidebarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getCustomerInfoPage(driver);
    }
}
