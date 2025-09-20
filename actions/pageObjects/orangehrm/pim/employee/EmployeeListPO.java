package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangehrm.pim.employee.EmployeeListPUI;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }

    public AddEmployeePO clickToAddEmployeeButton() {
        waitForElementClickable(driver, EmployeeListPUI.ADD_EMPLOYEE_BUTTON);
        clickToElement(driver, EmployeeListPUI.ADD_EMPLOYEE_BUTTON);

        return PageGenerator.getAddEmployeePage(driver);
    }
}
