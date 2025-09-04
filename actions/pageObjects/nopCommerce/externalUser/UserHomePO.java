package pageObjects.nopCommerce.externalUser;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.externalUser.sidebar.UserCustomerInfoPO;
import pageUIs.nopCommerce.externalUser.UserHomePageUI;
import pageUIs.nopCommerce.externalUser.UserRegisterPageUI;

public class UserHomePO extends BasePage {
    private WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Register button")
    public UserRegisterPO clickToRegisterLink() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);
    }

    @Step("Verify My Account Page is displayed")
    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return isControlDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }

    @Step("Click to My Account button")
    public UserCustomerInfoPO clickToMyAccountLink() {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserCustomerInfoPage(driver);
    }

    @Step("Click to Log In button")
    public UserLoginPageObject clickTLoginButton() {
        waitForElementClickable(driver, UserRegisterPageUI.LOGIN_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }
}
