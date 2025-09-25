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
import jsonData.nopCommerce.UserInfoByJson;

@Feature("User")
public class Level_23_Data_Driven_JSON extends BaseTest {
    @Parameters({"browser","userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);

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
    private UserHomePO homePage;
    private UserLoginPageObject loginPage;
    private UserRegisterPO registerPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserInfoByJson userInfo;
    private String firstName, lastName, day, month, year, emailAddress, companyName, password;

}
