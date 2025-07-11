package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory extends BasePage   {
    private WebDriver driver;

    public RegisterPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@id='gender-male']")
    private WebElement GENDER_MALE_RADIO;

    @FindBy(how = How.XPATH, using = "//input[@id='FirstName']")
    private WebElement FIRST_NAME_TEXTBOX;

    @FindBy(how = How.XPATH, using = "//input[@id='LastName']")
    private WebElement LAST_NAME_TEXTBOX;

    @FindBy(how = How.XPATH, using = "//input[@id='Email']")
    private WebElement EMAIL_TEXTBOX;

    @FindBy(how = How.XPATH, using = "//input[@id='Company']")
    private WebElement COMPANY_NAME_TEXTBOX;

    @FindBy(how = How.XPATH, using = "//input[@id='Password']")
    private WebElement PASSWORD_TEXTBOX;

    @FindBy(how = How.XPATH, using = "//input[@id='ConfirmPassword']")
    private WebElement CONFIRM_PASSWORD_TEXTBOX;

    @FindBy(how = How.XPATH, using = "//button[@id='register-button']")
    private WebElement REGISTER_BUTTON;

    @FindBy(how = How.XPATH, using = "//div[@class='result']")
    private WebElement REGISTER_SUCCESS_MESSAGE;

    @FindBy(how = How.XPATH, using = "//a[@class='ico-logout']")
    private WebElement LOGOUT_LINK;

    @FindBy(how = How.XPATH, using = "//a[@class='ico-login']")
    private WebElement LOGIN_LINK;

    public void clickToMaleRadio() {
        waitForElementClickable(driver, GENDER_MALE_RADIO);
        clickToElement(GENDER_MALE_RADIO);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, FIRST_NAME_TEXTBOX);
        sendkeyToElement(FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, LAST_NAME_TEXTBOX);
        sendkeyToElement(LAST_NAME_TEXTBOX, lastName);
    }

//    public void selectDayDropdown(String day) {
//        waitForElementClickable(driver, DAY_DROPDOWN);
//        selectItemInDropdown(driver, DAY_DROPDOWN, day);
//    }
//
//    public void selectMonthDropdown(String month) {
//        waitForElementClickable(driver, MONTH_DROPDOWN);
//        selectItemInDropdown(driver, MONTH_DROPDOWN, month);
//    }
//
//    public void selectYearDropdown(String year) {
//        waitForElementClickable(driver, YEAR_DROPDOWN);
//        selectItemInDropdown(driver, YEAR_DROPDOWN, year);
//    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, EMAIL_TEXTBOX);
        sendkeyToElement(EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToCompanyTextbox(String companyName) {
        waitForElementVisible(driver, COMPANY_NAME_TEXTBOX);
        sendkeyToElement(COMPANY_NAME_TEXTBOX, companyName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, PASSWORD_TEXTBOX);
        sendkeyToElement(PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public void clickTRegisterButton() {
        waitForElementClickable(driver, REGISTER_BUTTON);
        clickToElement(REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        return getElementText(REGISTER_SUCCESS_MESSAGE);
    }

    public void clickTLogoutButton() {
        waitForElementClickable(driver, LOGOUT_LINK);
        clickToElement(LOGOUT_LINK);
    }

    public void clickTLoginButton() {
        waitForElementClickable(driver, LOGIN_LINK);
        clickToElement(LOGIN_LINK);
    }
}
