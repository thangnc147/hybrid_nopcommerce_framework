package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_III_Inheritance extends BasePage {
    WebDriver driver;
    String firstName, lastName, day, month, year, emailAddress, companyName, password;

    @BeforeClass
    public void beforeClass() {
        driver = new EdgeDriver();

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
        waitForElementClickable(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//a[@class='ico-register']");

        waitForElementClickable(driver, "//input[@id='gender-male']");
        clickToElement(driver, "//input[@id='gender-male']");

        sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
        sendkeyToElement(driver, "//input[@id='LastName']", lastName);

//        selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", day);
//        selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", month);
//        selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", year);

        sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
        sendkeyToElement(driver, "//input[@id='Company']", companyName);
        sendkeyToElement(driver, "//input[@id='Password']", password);
        sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);

        waitForElementClickable(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

        waitForElementClickable(driver, "//a[@class='ico-logout']");
        clickToElement(driver, "//a[@class='ico-logout']");
//        driver.findElement(By.cssSelector("a.ico-logout")).click();
    }

    @Test
    public void TC_02_Login() {
        waitForElementClickable(driver, "//a[@class='ico-login']");
        clickToElement(driver, "//a[@class='ico-login']");

        sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
        sendkeyToElement(driver, "//input[@id='Password']", password);

        waitForElementClickable(driver, "//button[text()='Log in']");
        clickToElement(driver, "//button[text()='Log in']");

        Assert.assertTrue(isControlDisplayed(driver, "//a[@class='ico-account' and text()='My account']"));
    }

    @Test
    public void TC_03_My_Account() {
        waitForElementClickable(driver, "//a[@class='ico-account']");
        clickToElement(driver, "//a[@class='ico-account']");

        Assert.assertTrue(isControlSelected(driver, "//input[@id='gender-male']"));

        Assert.assertEquals(getAttributeValue(driver, "//input[@id='FirstName']", "value"), firstName);
        Assert.assertEquals(getAttributeValue(driver, "//input[@id='LastName']", "value"), lastName);
        Assert.assertEquals(getAttributeValue(driver, "//input[@id='Company']", "value"), companyName);

//        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).getFirstSelectedOption().getText(), day);
//        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).getFirstSelectedOption().getText(), month);
//        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).getFirstSelectedOption().getText(), year);
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
