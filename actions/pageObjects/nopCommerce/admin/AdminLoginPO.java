package pageObjects.nopCommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    private WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    private void enterToUsernameTextbox(String username) {
        waitForElementVisible(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX, username);
    }

    private void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX, password);
    }

    private AdminDashboardPO clickTLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
        return PageGenerator.getAdminDashboardPage(driver);
    }

    public AdminDashboardPO loginToSystem(String username, String password) {
        enterToUsernameTextbox(username);
        enterToPasswordTextbox(password);
        clickTLoginButton();
        return PageGenerator.getAdminDashboardPage(driver);
    }
}
