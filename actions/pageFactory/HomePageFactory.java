package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory extends BasePage   {
    private WebDriver driver;

    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
    private WebElement REGISTER_LINK;

    @FindBy(how = How.XPATH, using = "//a[@class='ico-account' and text()='My account']")
    private WebElement MY_ACCOUNT_LINK;

    public void clickToRegisterLink() {
        waitForElementClickable(driver, REGISTER_LINK);
        clickToElement(REGISTER_LINK);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, MY_ACCOUNT_LINK);
        return isControlDisplayed(MY_ACCOUNT_LINK);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver, MY_ACCOUNT_LINK);
        clickToElement(MY_ACCOUNT_LINK);
    }
}
