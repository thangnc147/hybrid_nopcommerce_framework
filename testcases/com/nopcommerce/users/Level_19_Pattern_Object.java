package com.nopcommerce.users;

import commons.BaseTest;
import jiraConfigs.JiraCreateIssue;
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

public class Level_19_Pattern_Object extends BaseTest {
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
        registerPage = homePage.clickToRegisterLink();

        registerPage.clickToMaleRadio();
        registerPage.clickToRadioByID(driver, "gender-male");

        registerPage.enterToTextboxByID(driver, "FirstName", firstName);

        registerPage.enterToTextboxByID(driver, "LastName", lastName);

        registerPage.enterToTextboxByID(driver, "Email", emailAddress);

        registerPage.enterToTextboxByID(driver, "Company", companyName);

        registerPage.clickToCheckboxByID(driver, "Newsletter");

        registerPage.enterToTextboxByID(driver, "Password", password);

        registerPage.enterToTextboxByID(driver, "ConfirmPassword", password);

        registerPage.clickToButtonByText(driver, "Register");

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void TC_02_Login() {
        homePage = registerPage.clickTLogoutLink();

        loginPage = homePage.clickTLoginButton();


        loginPage.enterToTextboxByID(driver, "Email", emailAddress);
        loginPage.enterToTextboxByID(driver, "Password", password);
        loginPage.clickToButtonByText(driver, "Log in");

        homePage = PageGenerator.getUserHomePage(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void TC_03_My_Account() {
        customerInfoPage = homePage.clickToMyAccountLink();

        Assert.assertTrue(customerInfoPage.isRaditoSelectedByID(driver, "gender-male"));
        Assert.assertTrue(customerInfoPage.isCheckboxSelectedByID(driver, "Newsletter"));
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), firstName);
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), lastName);
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Company"), companyName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
