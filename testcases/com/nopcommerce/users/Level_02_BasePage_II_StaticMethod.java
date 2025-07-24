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

public class Level_02_BasePage_II_StaticMethod {
    WebDriver driver;
    BasePage basePage;
    String firstName, lastName, day, month, year, emailAddress, companyName, password;

    @BeforeClass
    public void beforeClass() {
        driver = new EdgeDriver();

        basePage = BasePage.getBasePage(); // Static Method

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
        basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.waitForElementClickable(driver, "//input[@id='gender-male']");
        basePage.clickToElement(driver, "//input[@id='gender-male']");

        basePage.sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
        basePage.sendkeyToElement(driver, "//input[@id='LastName']", lastName);

//        basePage.selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", day);
//        basePage.selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", month);
//        basePage.selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", year);

        basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.sendkeyToElement(driver, "//input[@id='Company']", companyName);
        basePage.sendkeyToElement(driver, "//input[@id='Password']", password);
        basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);

        basePage.waitForElementClickable(driver, "//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");

        basePage.waitForElementClickable(driver, "//a[@class='ico-logout']");
        basePage.clickToElement(driver, "//a[@class='ico-logout']");
//        driver.findElement(By.cssSelector("a.ico-logout")).click();
    }

    @Test
    public void TC_02_Login() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-login']");
        basePage.clickToElement(driver, "//a[@class='ico-login']");

        basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.sendkeyToElement(driver, "//input[@id='Password']", password);

        basePage.waitForElementClickable(driver, "//button[text()='Log in']");
        basePage.clickToElement(driver, "//button[text()='Log in']");

        Assert.assertTrue(basePage.isControlDisplayed(driver, "//a[@class='ico-account' and text()='My account']"));
    }

    @Test
    public void TC_03_Login() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-account']");
        basePage.clickToElement(driver, "//a[@class='ico-account']");

        Assert.assertTrue(basePage.isControlSelected(driver, "//input[@id='gender-male']"));

        Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='FirstName']", "value"), firstName);
        Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='LastName']", "value"), lastName);
        Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='Company']", "value"), companyName);

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
