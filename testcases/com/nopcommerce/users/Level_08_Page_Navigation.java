package com.nopcommerce.users;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.sidebar.AddressPageObject;
import pageObjects.sidebar.CustomerInfoPageObject;
import pageObjects.sidebar.OrderPageObject;
import pageObjects.sidebar.RewardPointPageObject;

import java.util.Random;

public class Level_08_Page_Navigation extends BaseTest {
//    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;
    private CustomerInfoPageObject customerInfoPage;
    private AddressPageObject addressPage;
    private OrderPageObject orderPage;
    private RewardPointPageObject rewardPointPage;
    String firstName, lastName, day, month, year, emailAddress, companyName, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {

        driver = getBrowserDriver(browserName);

        homePage = PageGenerator.getHomePage(driver);

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

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        homePage = loginPage.clickTLoginButton();

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
    public void TC_04_Swicth_Page() {
        // Customer Info -> Address
        addressPage = customerInfoPage.openAddressPage();

        // Address - > Reward Point
        rewardPointPage = addressPage.openRewardPointPage();

        // Reward Point -> Order
        orderPage = rewardPointPage.openOrderPage();

        // Order -> Address
        addressPage = orderPage.openAddressPage();

        // Address -> Customer Info
        customerInfoPage = addressPage.openCustomerInfoPage();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int generateRandomNumber() {
        return new Random().nextInt(99999);
    }

}
