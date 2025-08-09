package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.admin.AdminDashboardPO;
import pageObjects.admin.AdminLoginPO;
import pageObjects.externalUser.UserHomePO;
import pageObjects.externalUser.UserLoginPageObject;
import pageObjects.externalUser.UserRegisterPO;
import pageObjects.externalUser.sidebar.UserAddressPO;
import pageObjects.externalUser.sidebar.UserCustomerInfoPO;
import pageObjects.externalUser.sidebar.UserOrderPageObject;
import pageObjects.externalUser.sidebar.UserRewardPointPO;

public class PageGenerator extends BasePage {
    public static UserHomePO getUserHomePage(WebDriver driver) {
        return new UserHomePO(driver);
    }

    public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
        return new UserLoginPageObject(driver);
    }

    public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPO(driver);
    }

    public static UserCustomerInfoPO getUserCustomerInfoPage(WebDriver driver) {
        return new UserCustomerInfoPO(driver);
    }

    public static UserAddressPO getUserAddressPage(WebDriver driver) {
        return new UserAddressPO(driver);
    }

    public static UserOrderPageObject getUserOrderPage(WebDriver driver) {
        return new UserOrderPageObject(driver);
    }

    public static UserRewardPointPO getUserRewardPointPage(WebDriver driver) {
        return new UserRewardPointPO(driver);
    }

    public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPO(driver);
    }

    public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPO(driver);
    }


}
