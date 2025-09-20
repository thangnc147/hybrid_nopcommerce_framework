package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.pim.employee.EmployeePersonalDetailsPUI;

public class EmployeePersonalDetailsPO extends BasePage {
    private WebDriver driver;

    public EmployeePersonalDetailsPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.PAGE_TITLE);
        return getElementText(driver, EmployeePersonalDetailsPUI.PAGE_TITLE);
    }

    public String getFirstNameText() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.FIRST_NAME_TEXTBOX);
        return getElementText(driver, EmployeePersonalDetailsPUI.FIRST_NAME_TEXTBOX);
    }

    public String getMiddleNameText() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.MIDDLE_NAME_TEXTBOX);
        return getElementText(driver, EmployeePersonalDetailsPUI.MIDDLE_NAME_TEXTBOX);
    }

    public String getLastNameText() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.LAST_NAME_TEXTBOX);
        return getElementText(driver, EmployeePersonalDetailsPUI.LAST_NAME_TEXTBOX);
    }

    public String getEmployeeId() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX);
        return getElementText(driver, EmployeePersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX);
    }
}
