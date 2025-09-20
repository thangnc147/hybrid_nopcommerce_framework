package com.orangehrm.pim;

import commons.BaseTest;
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

public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private AddEmployeePO addEmployeePage;
    private EmployeeListPO employeeListPage;
    private EmployeePersonalDetailsPO PersonalDetailsPage;
    private EmergencyContactsPO emergencyContactsPage;
    private ContactDetailsPO contactDetailsPage;
    String usernsame, password;
    String firstName, middleName, lastName, employeeId;

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

        loginPage.enterToUsernameTextbox(usernsame);
        loginPage.enterToPasswordTextbox(password);
        dashboardPage = loginPage.clickToLoginButton();
    }

    @Test
    public void Employee_01_Add_New() {
        employeeListPage = dashboardPage.clickToPIMButton();

        addEmployeePage = employeeListPage.clickToAddEmployeeButton();

        addEmployeePage.enterToFirstNameTextbox(firstName);
        addEmployeePage.enterToMiddleNameTextbox(middleName);
        addEmployeePage.enterToLastNameTextbox(lastName);
        employeeId = addEmployeePage.getEmployeeId();

        PersonalDetailsPage = addEmployeePage.clickToSaveButton();

        Assert.assertEquals(PersonalDetailsPage.getPageTitle(), "Personal Details");
        Assert.assertEquals(PersonalDetailsPage.getFirstNameText(), firstName);
        Assert.assertEquals(PersonalDetailsPage.getMiddleNameText(), middleName);
        Assert.assertEquals(PersonalDetailsPage.getLastNameText(), lastName);
        Assert.assertEquals(PersonalDetailsPage.getEmployeeId(), employeeId);
    }

//    @Test
//    public void Employee_02_Upload_Avatar() {
//
//
//    }
//
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
