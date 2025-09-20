package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.employee.EmployeeListPO;
import pageUIs.orangehrm.DashboardPUI;

public class DashboardPO extends BasePage {
    private WebDriver driver;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public EmployeeListPO clickToPIMButton() {
        waitForElementClickable(driver, DashboardPUI.PIM_BUTTON);
        clickToElement(driver, DashboardPUI.PIM_BUTTON);

        return PageGenerator.getEmployeeListPage(driver);
    }
}
