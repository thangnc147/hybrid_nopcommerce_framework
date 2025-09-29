package com.nopcommerce.users;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jsonData.nopCommerce.UserInfoByJson;
import org.aeonbits.owner.ConfigFactory;
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
import utilities.EnvironmentConfig;

@Feature("User")
public class Level_24_Multiple_Env_02_Owner_Lib extends BaseTest {
    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environment) {
        ConfigFactory.setProperty("environment", environment);
        environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

        driver = getBrowserDriver(browserName, environmentConfig.appUrl());

        homePage = PageGenerator.getUserHomePage(driver);

        userInfo = UserInfoByJson.getUserInfo();

        firstName = userInfo.getFirstName();
        lastName = userInfo.getLastName();
        day = userInfo.getDay();
        month = userInfo.getMonth();
        year = userInfo.getYear();
        emailAddress = userInfo.getEmailAddress() + generateRandomNumber() + "@gmail.ccoommm";
        userInfo.setEmailAddress(emailAddress);
        companyName = userInfo.getCompanyName();
        password = userInfo.getPassword();
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

        verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }

    @Description("Login to system with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC_02_Login() {

        registerPage.clickTLogoutButton();

        loginPage = registerPage.clickTLoginButton();

        homePage = loginPage.loginToSystem(emailAddress, password);

        verifyTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Description("Access My Account and Verify info")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void TC_03_My_Account() {

        customerInfoPage = homePage.clickToMyAccountLink();

        verifyTrue(customerInfoPage.isGenderMaleSelected());
        verifyEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        verifyEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
        verifyEquals(customerInfoPage.getCompanyTextboxValue(), companyName);
    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private EnvironmentConfig environmentConfig;
    private UserHomePO homePage;
    private UserLoginPageObject loginPage;
    private UserRegisterPO registerPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserInfoByJson userInfo;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password;

}
