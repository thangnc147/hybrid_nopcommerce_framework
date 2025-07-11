package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPageFactory extends BasePage   {
    private WebDriver driver;

    public CustomerInfoPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@id='gender-male']")
    private WebElement GENDER_MALE_RADIO;

    @FindBy(how = How.XPATH, using = "//input[@id='FirstName']")
    private WebElement FIRST_NAME_TEXTBOX;

    @FindBy(how = How.XPATH, using = "//input[@id='LastName']")
    private WebElement LAST_NAME_TEXTBOX;

    @FindBy(how = How.XPATH, using = "//input[@id='Company']")
    private WebElement COMPANY_NAME_TEXTBOX;

    public boolean isGenderMaleSelected() {
        waitForElementSelected(driver, GENDER_MALE_RADIO);
        return isControlSelected(GENDER_MALE_RADIO);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, FIRST_NAME_TEXTBOX);
        return getAttributeValue(FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, LAST_NAME_TEXTBOX);
        return getAttributeValue(LAST_NAME_TEXTBOX, "value");
    }

    public String getCompanyTextboxValue() {
        waitForElementVisible(driver, GENDER_MALE_RADIO);
        return getAttributeValue(COMPANY_NAME_TEXTBOX, "value");
    }
}
