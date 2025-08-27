package assertVerify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestNG_03_Assert_Message {
    @Test
    public void showMessage() {
        boolean statusGender = true;

        Assert.assertTrue(statusGender, "Gender is not male!!!");
    }
}
