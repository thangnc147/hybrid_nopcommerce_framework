package com.nopcommerce.users;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

@Feature("User")
public class Level_16_Allure_Report extends BaseTest {
//    private WebDriver driver;
    String browserName;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        this.browserName = browserName;

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

    @Description("Register a new account")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void TC_01_Register() {

        registerPage = homePage.clickToRegisterLink();

        registerPage.clickToMaleRadio();

        registerPage.enterToFirstNameTextbox(firstName);

        registerPage.enterToLastNameTextbox(lastName);

        registerPage.enterToEmailTextbox(emailAddress);

        registerPage.enterToCompanyTextbox(companyName);

        registerPage.enterToPasswordTextbox(password);

        registerPage.enterToConfirmPasswordTextbox(password);

        registerPage.clickTRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed1");
    }

    @Description("Login to system with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC_02_Login() {

        registerPage.clickTLogoutButton();

        loginPage = registerPage.clickTLoginButton();

        homePage = loginPage.loginToSystem(emailAddress, password);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Description("Access My Account and Verify info")
    @Severity(SeverityLevel.MINOR)
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

    private UserHomePO homePage;
    private UserLoginPageObject loginPage;
    private UserRegisterPO registerPage;
    private UserCustomerInfoPO customerInfoPage;
    String firstName, lastName, day, month, year, emailAddress, companyName, password;
}
