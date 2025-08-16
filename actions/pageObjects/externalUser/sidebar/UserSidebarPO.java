package pageObjects.externalUser.sidebar;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.externalUser.UserSidebarPageUI;

public class UserSidebarPO extends BasePage {
    private WebDriver driver;

    public UserSidebarPO(WebDriver driver) {
        this.driver = driver;
    }

    public UserRewardPointPO openRewardPointPage() {
        waitForElementClickable(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPointPage(driver);
    }

    public UserAddressPO openAddressPage() {
        waitForElementClickable(driver, UserSidebarPageUI.ADDRESS_LINK);
        clickToElement(driver, UserSidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }

    public UserOrderPageObject openOrderPage() {
        waitForElementClickable(driver, UserSidebarPageUI.ORDER_LINK);
        clickToElement(driver, UserSidebarPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage() {
        waitForElementClickable(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerInfoPage(driver);
    }

    public UserSidebarPO openSidebarLinkByPageName(String pageName) {
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);

        switch (pageName) {
            case "Addresses":
                return PageGenerator.getUserAddressPage(driver);
            case "Reward points":
                return PageGenerator.getUserRewardPointPage(driver);
            case "Customer info":
                return PageGenerator.getUserCustomerInfoPage(driver);
            case "Orders":
                return PageGenerator.getUserOrderPage(driver);
            default:
                throw new RuntimeException("Page name is not valid!");
        }
    }

    public void openSidebarLinkByPageNames(String pageName) {
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
    }
}
