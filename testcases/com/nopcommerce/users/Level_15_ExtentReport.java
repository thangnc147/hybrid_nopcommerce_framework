package com.nopcommerce.users;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.externalUser.UserHomePO;
import pageObjects.nopCommerce.externalUser.UserLoginPageObject;
import pageObjects.nopCommerce.externalUser.UserRegisterPO;
import pageObjects.nopCommerce.externalUser.sidebar.UserAddressPO;
import pageObjects.nopCommerce.externalUser.sidebar.UserCustomerInfoPO;
import pageObjects.nopCommerce.externalUser.sidebar.UserOrderPageObject;
import pageObjects.nopCommerce.externalUser.sidebar.UserRewardPointPO;

import java.lang.reflect.Method;

public class Level_15_ExtentReport extends BaseTest {
//    private WebDriver driver;
    private UserHomePO homePage;
    private UserLoginPageObject loginPage;
    private UserRegisterPO registerPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserAddressPO addressPage;
    private UserOrderPageObject orderPage;
    private UserRewardPointPO rewardPointPage;
    String firstName, lastName, day, month, year, emailAddress, companyName, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {

        driver = getBrowserDriver(browserName);

        homePage = PageGenerator.getUserHomePage(driver);

        firstName = "Thang";
        lastName = "Nguyen";
        day = "10";
        month = "July";
        year = "1000";
        emailAddress = "thang" + generateRandomNumber() + "@gmail.ccoomm";
        companyName = "Thang Company";
        password = "ThangPassword";
    }


    @Test
    public void TC_01_Register(Method method) {
//        ExtentManager.startTest(method.getName(), "TC_01_Register");

//        ExtentManager.getTest().log(LogStatus.INFO, "NewCustomer - Step 01: Open 'New Customer' Page");
        registerPage = homePage.clickToRegisterLink();

//        ExtentManager.getTest().log(LogStatus.INFO,"TC_01_Register - Step 02: Click to Male radio button");
        registerPage.clickToMaleRadio();

//        ExtentManager.getTest().log(LogStatus.INFO,"TC_01_Register - Step 03: Input to FirstName textbox with value: " + firstName);
        registerPage.enterToFirstNameTextbox(firstName);

//        ExtentManager.getTest().log(LogStatus.INFO,"TC_01_Register - Step 04: Input to LastName textbox with value: " + lastName);
        registerPage.enterToLastNameTextbox(lastName);

//        ExtentManager.getTest().log(LogStatus.INFO,"TC_01_Register - Step 05: Input to Email Address textbox with value: " + emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

//        ExtentManager.getTest().log(LogStatus.INFO,"TC_01_Register - Step 06: Input to Company Name textbox with value: " + companyName);
        registerPage.enterToCompanyTextbox(companyName);

//         ExtentManager.getTest().log(LogStatus.INFO,"TC_01_Register - Step 07: Input to Password textbox with value: " + password);
        registerPage.enterToPasswordTextbox(password);

//         ExtentManager.getTest().log(LogStatus.INFO,"TC_01_Register - Step 08: Input to Confirm Password textbox with value: " + password);
        registerPage.enterToConfirmPasswordTextbox(password);

//         ExtentManager.getTest().log(LogStatus.INFO,"TC_01_Register - Step 09: Click to Register button");
        registerPage.clickTRegisterButton();

//         ExtentManager.getTest().log(LogStatus.INFO,"TC_01_Register - Step 10: Verify success message is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed1");


    }

    @Test
    public void TC_02_Login(Method method) {
//        ExtentManager.startTest(method.getName(), "TC_02_Login");
////        ExtentManager.getTest().log(LogStatus.INFO, "NewCustomer - Step 01: Open 'New Customer' Page");

//         ExtentManager.getTest().log(LogStatus.INFO,"TC_02_Login - Step 00: Click to Log Out button");
        registerPage.clickTLogoutButton();

//         ExtentManager.getTest().log(LogStatus.INFO,"TC_02_Login - Step 01: Click to Log In button");
        loginPage = registerPage.clickTLoginButton();

//         ExtentManager.getTest().log(LogStatus.INFO,"TC_02_Login - Step 02: Login to system with username " + emailAddress + "and password " + password);
        homePage = loginPage.loginToSystem(emailAddress, password);

//         ExtentManager.getTest().log(LogStatus.INFO,"TC_02_Login - Step 03: Verify My Account page is displayed");
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void TC_03_My_Account(Method method) {
//        ExtentManager.startTest(method.getName(), "TC_03_My_Account");
////        ExtentManager.getTest().log(LogStatus.INFO, "NewCustomer - Step 01: Open 'New Customer' Page");

        customerInfoPage = homePage.clickToMyAccountLink();

        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), companyName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
