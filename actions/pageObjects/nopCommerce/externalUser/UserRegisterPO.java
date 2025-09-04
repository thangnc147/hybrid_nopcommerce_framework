package pageObjects.nopCommerce.externalUser;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.externalUser.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Male Redio Button")
    public void clickToMaleRadio() {
        waitForElementClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
        clickToElement(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
    }

    @Step("Enter to First Name textbox with value: {0}")
    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    @Step("Enter to Last Name textbox with value: {0}")
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

//    public void selectDayDropdown(String day) {
//        waitForElementClickable(driver, RegisterPageUI.DAY_DROPDOWN);
//        selectItemInDropdown(driver, RegisterPageUI.DAY_DROPDOWN, day);
//    }
//
//    public void selectMonthDropdown(String month) {
//        waitForElementClickable(driver, RegisterPageUI.MONTH_DROPDOWN);
//        selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, month);
//    }
//
//    public void selectYearDropdown(String year) {
//        waitForElementClickable(driver, RegisterPageUI.YEAR_DROPDOWN);
//        selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, year);
//    }

    @Step("Enter to Email textbox with value: {0}")
    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    @Step("Enter to Company textbox with value: {0}")
    public void enterToCompanyTextbox(String companyName) {
        waitForElementVisible(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX, companyName);
    }

    @Step("Enter to Password textbox with value: {0}")
    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter to Confirm Password textbox with value: {0}")
    public void enterToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    @Step("Click to Register Button")
    public void clickTRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    @Step("Get Register Success Message")
    public String getRegisterSuccessMessage() {
        return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    @Step("Click to Log Out button")
    public void clickTLogoutButton() {
        waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
    }

    @Step("Click to Log Out link")
    public UserHomePO clickTLogoutLink() {
        waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
        return PageGenerator.getUserHomePage(driver);
    }

    @Step("Click to Log In button")
    public UserLoginPageObject clickTLoginButton() {
        waitForElementClickable(driver, UserRegisterPageUI.LOGIN_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }

    @Step("Get Register Page Title Message")
    public String getRegisterPageTitle() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
    }
}
