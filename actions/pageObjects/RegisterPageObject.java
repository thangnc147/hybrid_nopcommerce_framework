package pageObjects;

import com.nopcommerce.users.Level_03_Base_Object_Pattern;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToMaleRadio() {
        waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
        clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
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

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToCompanyTextbox(String companyName) {
        waitForElementVisible(driver, RegisterPageUI.COMPANY_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.COMPANY_NAME_TEXTBOX, companyName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public void clickTRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public void clickTLogoutButton() {
        waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
    }

    public void clickTLoginButton() {
        waitForElementClickable(driver, RegisterPageUI.LOGIN_LINK);
        clickToElement(driver, RegisterPageUI.LOGIN_LINK);
    }
}
