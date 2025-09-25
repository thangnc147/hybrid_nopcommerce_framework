package com.nopcommerce.users;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.externalUser.UserHomePO;
import pageObjects.nopCommerce.externalUser.UserLoginPageObject;
import pageObjects.nopCommerce.externalUser.UserRegisterPO;
import pageObjects.nopCommerce.externalUser.sidebar.UserCustomerInfoPO;
import pojoData.nopCommerce.UserInfo;

@Feature("User")
public class Level_22_Manage_Data_Internal extends BaseTest {
    @Parameters({"browser","userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);

        homePage = PageGenerator.getUserHomePage(driver);

        userInfo = UserInfo.getUser();

        userInfo.setFirstName("Thang");
        userInfo.setLastName("Nguyen");
        userInfo.setDay("10");
        userInfo.setMonth("July");
        userInfo.setYear("1999");
        userInfo.setEmailAddress("thang" + generateRandomNumber() + "@gmail.ccoomm");
        userInfo.setCompanyName("Thang Company");
        userInfo.setPassword("ThangPassword");
    }

    @Description("Register a new account")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void TC_01_Register() {

        registerPage = homePage.clickToRegisterLink();

        registerPage.clickToMaleRadio();

        registerPage.enterToFirstNameTextbox(userInfo.getFirstName());

        registerPage.enterToLastNameTextbox(userInfo.getLastName());

        registerPage.enterToEmailTextbox(userInfo.getEmailAddress());

        registerPage.enterToCompanyTextbox(userInfo.getCompanyName());

        registerPage.enterToPasswordTextbox(userInfo.getPassword());

        registerPage.enterToConfirmPasswordTextbox(userInfo.getPassword());

        registerPage.clickTRegisterButton();

        verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }

    @Description("Login to system with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC_02_Login() {

        registerPage.clickTLogoutButton();

        loginPage = registerPage.clickTLoginButton();

        homePage = loginPage.loginToSystem(userInfo);

        verifyTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Description("Access My Account and Verify info")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void TC_03_My_Account() {

        customerInfoPage = homePage.clickToMyAccountLink();

        verifyTrue(customerInfoPage.isGenderMaleSelected());
        verifyEquals(customerInfoPage.getFirstNameTextboxValue(), userInfo.getFirstName());
        verifyEquals(customerInfoPage.getLastNameTextboxValue(), userInfo.getLastName());
        verifyEquals(customerInfoPage.getCompanyTextboxValue(), userInfo.getCompanyName());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private UserHomePO homePage;
    private UserLoginPageObject loginPage;
    private UserRegisterPO registerPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserInfo userInfo;
}
