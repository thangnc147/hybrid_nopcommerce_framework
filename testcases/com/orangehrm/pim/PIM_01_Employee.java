package com.orangehrm.pim;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangehrm.DashboardPO;
import pageObjects.orangehrm.LoginPO;
import pageObjects.orangehrm.PageGenerator;
import pageObjects.orangehrm.pim.employee.*;

@Feature("Employee Management")
public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private AddEmployeePO addEmployeePage;
    private EmployeeListPO employeeListPage;
    private EmployeePersonalDetailsPO personalDetailsPage;
    private EmergencyContactsPO emergencyContactsPage;
    private ContactDetailsPO contactDetailsPage;
    private String usernsame, password;
    private String firstName, middleName, lastName, employeeId;
    private String avatarImageName;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);

        loginPage = PageGenerator.getLoginPage(driver);

        usernsame = "thangnguyen";
        password = "jBg0xOKLJJNdjnn^Ej";

        firstName = "Thang";
        middleName = "Employee" + generateRandomNumber();
        lastName = "Nguyen";

        avatarImageName = "Image02.png";

        loginPage.enterToUsernameTextbox(usernsame);
        loginPage.enterToPasswordTextbox(password);
        dashboardPage = loginPage.clickToLoginButton();
    }

    @Description("Add a new Employee record")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void Employee_01_Add_New() {
        // Wait all loading is done
        employeeListPage = dashboardPage.clickToPIMButton();

        addEmployeePage = employeeListPage.clickToAddEmployeeButton();

        addEmployeePage.enterToFirstNameTextbox(firstName);
        addEmployeePage.enterToMiddleNameTextbox(middleName);
        addEmployeePage.enterToLastNameTextbox(lastName);
        employeeId = addEmployeePage.getEmployeeId();

        personalDetailsPage = addEmployeePage.clickToSaveButtonAtEmployeeCreation();

        Assert.assertEquals(personalDetailsPage.getPageTitle(), "Personal Details");

        // Wait for second Loading Icon After create
        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        Assert.assertEquals(personalDetailsPage.getFirstNameText(), firstName);
        Assert.assertEquals(personalDetailsPage.getMiddleNameText(), middleName);
        Assert.assertEquals(personalDetailsPage.getLastNameText(), lastName);
        Assert.assertEquals(personalDetailsPage.getEmployeeId(), employeeId);
    }

    @Description("Upload Avatar for Employee record")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Employee_02_Upload_Avatar() {
        personalDetailsPage.clickToEmployeeAvatarImage();

        // Get height/width of current avatar (Before Upload)
        Dimension beforeUpload = personalDetailsPage.getAvatarSize();
        System.out.println("Before Upload Size: " + beforeUpload);

        personalDetailsPage.loadAvatarImage(avatarImageName);

        personalDetailsPage.clickToSaveButtonAtChangeProfilePicture();

        // Verify Success Message showing
        personalDetailsPage.isSuccessMessageDisplayed();

        // Verify system done loading
        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        // Verify new avatar show up
        Assert.assertTrue(personalDetailsPage.isProfileAvatarUpdatedSuccess(beforeUpload));
    }

//    @Test
//    public void Employee_03_Personal_Details() {
//
//    }
//
//    @Test
//    public void Employee_04_Contact_Details() {
//
//    }
//
//    @Test
//    public void Employee_05_Emergency_Details() {
//
//    }
//
//    @Test
//    public void Employee_06_Assigned_Dependents() {
//
//    }

    @AfterClass (alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

}
