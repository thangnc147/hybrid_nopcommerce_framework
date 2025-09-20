package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
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

    @Step("Click to Employee Avatar Image")
    public void clickToEmployeeAvatarImage() {
        waitForElementClickable(driver, EmployeePersonalDetailsPUI.EMPLOYEE_PROFILE_IMAGE);
        clickToElement(driver, EmployeePersonalDetailsPUI.EMPLOYEE_PROFILE_IMAGE);
    }

    @Step("Upload new Avatar Image with filename: {0}")
    public void loadAvatarImage(String filename) {
        uploadMultipleFiles(driver, filename);
    }

    @Step("Click Save button to save new Avatar")
    public void clickToSaveButtonAtChangeProfilePicture() {
        waitForElementClickable(driver, EmployeePersonalDetailsPUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        clickToElement(driver, EmployeePersonalDetailsPUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
    }

    @Step("Verify Success Message is displayed")
    public boolean isSuccessMessageDisplayed() {
        waitForElementVisible(driver, EmployeePersonalDetailsPUI.SUCCESS_MESSAGE);
        return isElementDisplayed(driver, EmployeePersonalDetailsPUI.SUCCESS_MESSAGE);
    }

    public Dimension getAvatarSize() {
        return getElementSize(driver, EmployeePersonalDetailsPUI.EMPLOYEE_PROFILE_IMAGE);
    }

    @Step("Verify Avatar is updated successfuly.")
    public boolean isProfileAvatarUpdatedSuccess(Dimension beforeUpload) {
        Dimension afterUpload = getAvatarSize();
        System.out.println("After Upload Size: " + beforeUpload);
        return !(beforeUpload.equals(afterUpload));
    }
}
