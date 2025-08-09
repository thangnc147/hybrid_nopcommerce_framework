package com.nopcommerce.users;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.admin.AdminDashboardPO;
import pageObjects.admin.AdminLoginPO;
import pageObjects.externalUser.UserHomePO;
import pageObjects.externalUser.UserLoginPageObject;
import pageObjects.PageGenerator;
import pageObjects.externalUser.UserRegisterPO;
import pageObjects.externalUser.sidebar.UserCustomerInfoPO;

import java.util.Random;

public class Level_09_Switch_Site_URL extends BaseTest {
    private String userUrl, adminUrl;
    private UserHomePO userHomePage;
    private UserCustomerInfoPO userCustomerInfoPage;
    private UserLoginPageObject userLoginPage;
    private UserRegisterPO userRegisterPage;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPage;
    private String firstName, lastName, day, month, year, userEmailAddress, companyName, userPassword;
    private String adminEmailAddress, adminPassword, adminFirstName, adminLastName, adminCompanyName;

    @Parameters({"browser", "userUrl", "adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName,String userUrlValue, String adminUrlValue) {
        this.userUrl = userUrlValue;
        this.adminUrl = adminUrlValue;

        driver = getBrowserDriver(browserName, this.userUrl);

        userHomePage = PageGenerator.getUserHomePage(driver);

        firstName = "Thang";
        lastName = "Nguyen";
        day = "10";
        month = "July";
        year = "1000";
        userEmailAddress = "thang" + generateRandomNumber() + "@gmail.ccoomm";
        userPassword = "ThangPassword";
        companyName = "Thang Company";

        adminFirstName = "Thang";
        adminLastName = "Admin";
        adminEmailAddress = "ThangAdmin@NOPCOMMERCE.COM";
        adminPassword = "Thang@569559";
        adminCompanyName = "Thang Company";
    }


    @Test
    public void TC_01_Register() {
        userRegisterPage = userHomePage.clickToRegisterLink();

        userRegisterPage.clickToMaleRadio();

        userRegisterPage.enterToFirstNameTextbox(firstName);
        userRegisterPage.enterToLastNameTextbox(lastName);
        userRegisterPage.enterToEmailTextbox(userEmailAddress);
        userRegisterPage.enterToCompanyTextbox(companyName);
        userRegisterPage.enterToPasswordTextbox(userPassword);
        userRegisterPage.enterToConfirmPasswordTextbox(userPassword);
        userRegisterPage.clickTRegisterButton();

        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

        userHomePage = userRegisterPage.clickTLogoutLink();
    }

    @Test
    public void TC_02_Role_01_User_Site_To_Admin_Site() {
        userLoginPage = userHomePage.clickTLoginButton();

        userHomePage = userLoginPage.loginToSystem(userEmailAddress, userPassword);

        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

        // User order any Product

        // Admin to verfiy and approve the product:

        userHomePage.openPageUrl(driver, this.adminUrl);

        // If haven't login
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);
//        // If already login
//        adminDashboardPage = PageGenerator.getAdminDashboardPage(driver);

        // Admin Logging In
        adminDashboardPage = adminLoginPage.loginToSystem(adminEmailAddress, adminPassword);

    }

    @Test
    public void TC_03_Role_02_Admin_Site_To_User_Site() {
        adminDashboardPage.openPageUrl(driver, this.userUrl);
        userHomePage = PageGenerator.getUserHomePage(driver);

        userCustomerInfoPage = userHomePage.clickToMyAccountLink();
        Assert.assertTrue(userCustomerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(), adminFirstName);
        Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(), adminLastName);
//        Assert.assertEquals(userCustomerInfoPage.getCompanyTextboxValue(), adminCompanyName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int generateRandomNumber() {
        return new Random().nextInt(99999);
    }

}
