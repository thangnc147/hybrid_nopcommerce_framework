package com.jquery;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;

import java.util.Random;

public class Level_12_Upload extends BaseTest {
//    private WebDriver driver;
    private HomePO homePage;
    String image01, image02, image03;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGenerator.getHomePage(driver);

        image01 = "Image01.png";
        image02 = "Image02.png";
        image03 = "Image03.png";
    }


    @Test
    public void TC_Upload_01() {
        // Get correct file path on our device
        // Can run on all OS: Mac/ Window/ Linux

        // Upload 1 file
        homePage.uploadMultipleFiles(driver, image01);
        sleepInSeconds(3);
        homePage.refreshCurrentPage(driver);
        // Can upload multiple file
        homePage.uploadMultipleFiles(driver, image01, image02, image03);
        sleepInSeconds(3);

        // Can verify (1 or mutilple file uploaded)
        Assert.assertTrue(homePage.isFileLoadedByName(image01));
        Assert.assertTrue(homePage.isFileLoadedByName(image02));
        Assert.assertTrue(homePage.isFileLoadedByName(image03));

        // Click to Upload button
        homePage.clickToUploadButton(driver);

        Assert.assertTrue(homePage.isFileUploadedByName(image01));
        Assert.assertTrue(homePage.isFileUploadedByName(image02));
        Assert.assertTrue(homePage.isFileUploadedByName(image03));

        // Not care if File Dialog Open or not! --> Because we sendkey the path
    }

    @Test
    public void TC_Upload_02() {
    }

    @Test
    public void TC_Upload_03() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int generateRandomNumber() {
        return new Random().nextInt(99999);
    }

}
