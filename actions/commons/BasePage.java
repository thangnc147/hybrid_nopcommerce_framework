package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    private WebDriverWait explicitWait;
    private Alert alert;

    public static void get(WebDriver driver, String URL) {
        driver.get("URL");
    }

    public static void quit(WebDriver driver) {
        driver.quit();
    }

//    public static String getTitle() {
//        return driver.getTitle();
//    }
//
//    public static String getCurrentURL() {
//        return driver.getCurrentUrl();
//    }
//
//    public static String getPageSource() {
//        return driver.getPageSource();
//    }
//
//    public static void back() {
//        driver.navigate().back();
//    }
//
//    public static void forward() {
//        driver.navigate().forward();
//    }
//
//    public static void refresh() {
//        driver.navigate().refresh();
//    }
//
//    public static void Alert() {
//
//    }
//
//    public static void waitAlertPresence() {
//        explicitWait.until(ExpectedConditions.alertIsPresent());
//    }
//
//    public static void acceptAlert() {
//        driver.switchTo().alert().accept();
//    }
//
//    public static void cancelAlert() {
//        driver.switchTo().alert().dismiss();
//    }
//
//    public static String getTextAlert() {
//        return driver.switchTo().alert().getText();
//    }
//
//    public static void sendkeyToAlert(String key) {
//        driver.switchTo().alert().sendKeys(key);
//    }
//
//
////    public static void clickToElement() {
//        driver.findElement(By.cssSelector("")).click();
//    }
//
//    public static String getElementText() {
//        return driver.findElement(By.cssSelector("")).getText();
//    }
}
