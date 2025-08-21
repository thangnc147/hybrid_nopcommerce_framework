package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.jquery.HomePageUI;

public class HomePO extends BasePage {
    private WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageByNumber(String number) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_LINK, number);
        clickToElement(driver, HomePageUI.DYNAMIC_PAGE_LINK, number);
    }

    public boolean isPageNumberActive(String number) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_PAGE_LINK, number);
        return getAttributeValue(driver, HomePageUI.DYNAMIC_PAGE_LINK,"class", number).endsWith("active");
    }

    public void enterToTextboxByColumnName(String columnName, String value) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_NAME, columnName);
        sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_NAME, value, columnName);
        pressKeyboardToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_NAME, Keys.ENTER, columnName);
    }

    public boolean isRowValueDisplayed(String females, String country, String males, String total) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_DATA_ON_ROW, females, country, males, total);
        return isControlDisplayed(driver, HomePageUI.DYNAMIC_DATA_ON_ROW, females, country, males, total);
    }

    public void deleteRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_DELETE_BUTTONBY_COUNTRY, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_DELETE_BUTTONBY_COUNTRY, countryName);
    }

    public void clickEditButtonByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY, countryName);
    }
}
