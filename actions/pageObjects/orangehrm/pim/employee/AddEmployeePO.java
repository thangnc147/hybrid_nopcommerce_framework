package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangehrm.pim.employee.AddEmployeePUI;

public class AddEmployeePO extends BasePage {
    private WebDriver driver;

    public AddEmployeePO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, AddEmployeePUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, AddEmployeePUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToMiddleNameTextbox(String middleName) {
        waitForElementVisible(driver, AddEmployeePUI.MIDDLE_NAME_TEXTBOX);
        sendkeyToElement(driver, AddEmployeePUI.MIDDLE_NAME_TEXTBOX, middleName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, AddEmployeePUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, AddEmployeePUI.LAST_NAME_TEXTBOX, lastName);
    }

    public String getEmployeeId() {
        waitForElementVisible(driver, AddEmployeePUI.EMPLOEE_ID_TEXTBOX);
        return getElementText(driver, AddEmployeePUI.EMPLOEE_ID_TEXTBOX);
    }

    public EmployeePersonalDetailsPO clickToSaveButton() {
        waitForElementClickable(driver, AddEmployeePUI.SAVE_BUTTON);
        clickToElement(driver, AddEmployeePUI.SAVE_BUTTON);

        return PageGenerator .getEmployeePersonalDetailsPage(driver);
    }
}
