package pageObjects.nopCommerce.externalUser;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.externalUser.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
    private WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter to Email textbox with value: {0}")
    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    @Step("Enter to Password textbox with value: {0}")
    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click to Log In button")
    public UserHomePO clickTLoginButton() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getUserHomePage(driver);
    }

    @Step("Login To system with email address: {0} and password: {1}")
    public UserHomePO loginToSystem(String username, String password) {
        enterToEmailTextbox(username);
        enterToPasswordTextbox(password);
        clickTLoginButton();
        return PageGenerator.getUserHomePage(driver);
    }

}
