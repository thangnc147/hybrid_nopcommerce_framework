package pageUIs.orangehrm.pim.employee;

public class EmployeePersonalDetailsPUI {
    public static final String PAGE_TITLE = "XPath=//div[@class='orangehrm-edit-employee-content']/div/h6";
    public static final String FIRST_NAME_TEXTBOX = "name=firstName";
    public static final String MIDDLE_NAME_TEXTBOX = "name=middleName";
    public static final String LAST_NAME_TEXTBOX = "name=lastName";
    public static final String EMPLOYEE_ID_TEXTBOX = "Xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER = "Xpath=//h6[text()='Change Profile Picture']/parent::div/form//button[contains(string(), ' Save ')]";
    public static final String EMPLOYEE_PROFILE_IMAGE = "Xpath=//div[@class='orangehrm-edit-employee-image']//img[@alt='profile picture']";
    public static final String SUCCESS_MESSAGE = "Xpath=//div[contains(@class, 'oxd-toast-content')]/p[text()='Successfully Updated']";
}
