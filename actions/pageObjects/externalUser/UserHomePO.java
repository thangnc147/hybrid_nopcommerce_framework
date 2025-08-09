package pageObjects.externalUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.externalUser.sidebar.UserCustomerInfoPO;
import pageUIs.externalUser.UserHomePageUI;
import pageUIs.externalUser.UserRegisterPageUI;
import pageUIs.externalUser.UserSidebarPageUI;

public class UserHomePO extends BasePage {
    private WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPO clickToRegisterLink() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return isControlDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }

    public UserCustomerInfoPO clickToMyAccountLink() {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserCustomerInfoPage(driver);
    }

    public UserLoginPageObject clickTLoginButton() {
        waitForElementClickable(driver, UserRegisterPageUI.LOGIN_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }

}
