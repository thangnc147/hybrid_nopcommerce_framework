package pageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public void clickToElement(WebElement element) {
        element.click();
    }

    public void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isControlDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void waitForElementSelected(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeSelected(element));
    }

    public boolean isControlSelected(WebElement element) {
        return element.isSelected();
    }

    public String getAttributeValue(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public void sendkeyToElement(WebElement element, String key) {
        element.sendKeys(key);
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }
}
