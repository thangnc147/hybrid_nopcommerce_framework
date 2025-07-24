package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;
//    private String emailAddress = LoginPageUI.EMAIL_TEXTBOX;
//    private String password = LoginPageUI.PASSWORD_TEXTBOX;


    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public HomePageObject clickTLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getHomePage(driver);
    }

//    public HomePageObject loginToSystem() {
//        enterToEmailTextbox(emailAddress);
//        enterToPasswordTextbox(password);
//        clickTLoginButton();
//        return PageGenerator.getHomePage(driver);
//    }

}
