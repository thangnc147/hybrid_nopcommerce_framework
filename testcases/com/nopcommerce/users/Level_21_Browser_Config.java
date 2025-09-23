package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_21_Browser_Config extends BaseTest {
    private WebDriver driver;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);
    }

    @Test
    public void TC_01() {
    }

    @AfterClass (alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

}
