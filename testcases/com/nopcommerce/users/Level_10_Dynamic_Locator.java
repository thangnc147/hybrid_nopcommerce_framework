package com.nopcommerce.users;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.externalUser.UserHomePO;
import pageObjects.externalUser.UserLoginPageObject;
import pageObjects.externalUser.UserRegisterPO;
import pageObjects.externalUser.sidebar.UserAddressPO;
import pageObjects.externalUser.sidebar.UserCustomerInfoPO;
import pageObjects.externalUser.sidebar.UserOrderPageObject;
import pageObjects.externalUser.sidebar.UserRewardPointPO;

import java.util.Random;

public class Level_10_Dynamic_Locator extends BaseTest {
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

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        registerPage.clickTLogoutButton();
    }

    @Test
    public void TC_02_Login() {
        loginPage = registerPage.clickTLoginButton();

        homePage = loginPage.loginToSystem(emailAddress, password);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Test
    public void TC_03_My_Account() {
        customerInfoPage = homePage.clickToMyAccountLink();

        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), companyName);
    }

    @Test
    public void TC_04_Dynamic_Page() {
        // Customer Info -> Address
        addressPage = (UserAddressPO) customerInfoPage.openSidebarLinkByPageName("Addresses");

        // Address - > Reward Point
        rewardPointPage = (UserRewardPointPO) addressPage.openSidebarLinkByPageName("Reward points");

        // Reward Point -> Order
        orderPage = (UserOrderPageObject) rewardPointPage.openSidebarLinkByPageName("Orders");

        // Order -> Address
        addressPage = (UserAddressPO) orderPage.openSidebarLinkByPageName("Addresses");

        // Address -> Customer Info
        customerInfoPage = (UserCustomerInfoPO) addressPage.openSidebarLinkByPageName("Customer info");

    }

    @Test
    public void TC_05_Dynamic_Page() {
        // Customer Info -> Address
        customerInfoPage.openSidebarLinkByPageNames("Addresses");
        addressPage = PageGenerator.getUserAddressPage(driver);

        // Address - > Reward Point
        addressPage.openSidebarLinkByPageNames("Reward points");
        rewardPointPage = PageGenerator.getUserRewardPointPage(driver);

        // Reward Point -> Order
        rewardPointPage.openSidebarLinkByPageName("Orders");
        orderPage = PageGenerator.getUserOrderPage(driver);

        // Order -> Address
        orderPage.openSidebarLinkByPageName("Addresses");
        addressPage = PageGenerator.getUserAddressPage(driver);

        // Address -> Customer Info
        addressPage.openSidebarLinkByPageName("Customer info");
        customerInfoPage = PageGenerator.getUserCustomerInfoPage(driver);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int generateRandomNumber() {
        return new Random().nextInt(99999);
    }

}
