package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.pim.employee.EmployeePersonalDetailsPUI;

public class EmployeePersonalDetailsPO extends BasePage {
    private WebDriver driver;

    public EmployeePersonalDetailsPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get page title of the Employee Detail")
    public String getPageTitle() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.PAGE_TITLE);
        return getElementText(driver, EmployeePersonalDetailsPUI.PAGE_TITLE);
    }

    @Step("Get value of the First Name textbox")
    public String getFirstNameText() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.FIRST_NAME_TEXTBOX);
        return getAttributeValue(driver, EmployeePersonalDetailsPUI.FIRST_NAME_TEXTBOX, "value");
    }

    @Step("Get value of the Middle Name textbox")
    public String getMiddleNameText() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.MIDDLE_NAME_TEXTBOX);
        return getAttributeValue(driver, EmployeePersonalDetailsPUI.MIDDLE_NAME_TEXTBOX, "value");
    }

    @Step("Get value of the Last Name textbox")
    public String getLastNameText() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.LAST_NAME_TEXTBOX);
        return getAttributeValue(driver, EmployeePersonalDetailsPUI.LAST_NAME_TEXTBOX, "value");
    }

    @Step("Get value of the Emplopyee ID textbox")
    public String getEmployeeId() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX);
        return getAttributeValue(driver, EmployeePersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX, "value");
    }
}
