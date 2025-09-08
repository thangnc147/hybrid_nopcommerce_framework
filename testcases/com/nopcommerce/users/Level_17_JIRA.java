package com.nopcommerce.users;

import jiraConfigs.JiraCreateIssue;
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

public class Level_17_JIRA extends BaseTest {
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

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void TC_01_Register() {
        log.info("TC_01_Register - Step 01: Open Register Page");
        registerPage = homePage.clickToRegisterLink();

        log.info("TC_01_Register - Step 02: Click to Male radio button");
        registerPage.clickToMaleRadio();

        log.info("TC_01_Register - Step 03: Input to FirstName textbox with value: " + firstName);
        registerPage.enterToFirstNameTextbox(firstName);

        log.info("TC_01_Register - Step 04: Input to LastName textbox with value: " + lastName);
        registerPage.enterToLastNameTextbox(lastName);

        log.info("TC_01_Register - Step 05: Input to Email Address textbox with value: " + emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        log.info("TC_01_Register - Step 06: Input to Company Name textbox with value: " + companyName);
        registerPage.enterToCompanyTextbox(companyName);

        log.info("TC_01_Register - Step 07: Input to Password textbox with value: " + password);
        registerPage.enterToPasswordTextbox(password);

        log.info("TC_01_Register - Step 08: Input to Confirm Password textbox with value: " + password);
        registerPage.enterToConfirmPasswordTextbox(password);

        log.info("TC_01_Register - Step 09: Click to Register button");
        registerPage.clickTRegisterButton();

        log.info("TC_01_Register - Step 10: Verify success message is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed1");
    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void TC_02_Login() {
        log.info("TC_02_Login - Step 00: Click to Log Out button");
        registerPage.clickTLogoutButton();

        log.info("TC_02_Login - Step 01: Click to Log In button");
        loginPage = registerPage.clickTLoginButton();

        log.info("TC_02_Login - Step 02: Login to system with username " + emailAddress + "and password " + password);
        homePage = loginPage.loginToSystem(emailAddress, password);

        log.info("TC_02_Login - Step 03: Verify My Account page is displayed");
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void TC_03_My_Account() {
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
