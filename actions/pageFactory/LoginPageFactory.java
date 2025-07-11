package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage   {
    private WebDriver driver;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@id='Email']")
    private WebElement EMAIL_TEXTBOX;

    @FindBy(how = How.XPATH, using = "//input[@id='Password']")
    private WebElement PASSWORD_TEXTBOX;

    @FindBy(how = How.XPATH, using = "//button[text()='Log in']")
    private WebElement LOGIN_BUTTON;

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, EMAIL_TEXTBOX);
        sendkeyToElement(EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, PASSWORD_TEXTBOX);
        sendkeyToElement(PASSWORD_TEXTBOX, password);
    }

    public void clickTLoginButton() {
        waitForElementClickable(driver, LOGIN_BUTTON);
        clickToElement(LOGIN_BUTTON);
    }
}
