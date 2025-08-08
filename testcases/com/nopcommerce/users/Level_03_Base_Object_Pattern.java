package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.sidebar.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;
import java.util.Random;

public class Level_03_Base_Object_Pattern extends BasePage {
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;
    private CustomerInfoPageObject customerInfoPage;
    String firstName, lastName, day, month, year, emailAddress, companyName, password;

    @BeforeClass
    public void beforeClass() {
        driver = new EdgeDriver();

        homePage = new HomePageObject(driver);

        driver.get("http://demo.nopcommerce/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

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
        // Action 1
        homePage.clickToRegisterLink();

        // From Home Page to Register Page
        registerPage = new RegisterPageObject(driver);

        registerPage.clickToMaleRadio();

        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
//        registerPage.selectDayDropdown("");
//        registerPage.selectMonthDropdown("");
//        registerPage.selectYearDropdown("");
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
        registerPage.clickTLoginButton();

        // From Register Page to Login Page
        loginPage = new LoginPageObject(driver);

        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickTLoginButton();

        // From Login Page to Home Page
        homePage = new HomePageObject(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void TC_03_My_Account() {
        homePage.clickToMyAccountLink();

        // From Register Page to Login Page
        customerInfoPage = new CustomerInfoPageObject(driver);

        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());

        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), companyName);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int generateRandomNumber() {
        return new Random().nextInt(99999);
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
