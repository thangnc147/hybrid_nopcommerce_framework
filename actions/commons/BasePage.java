package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import pageObjects.sidebar.AddressPageObject;
import pageObjects.sidebar.CustomerInfoPageObject;
import pageObjects.sidebar.OrderPageObject;
import pageObjects.sidebar.RewardPointPageObject;
import pageUIs.SidebarPageUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    // Map Driver
//    private WebDriver driver;
//    public BasePage(WebDriver driver) {
//        this.driver;
//    }

    // Encapsulation
    public static BasePage getBasePage() {
        return new BasePage();
    }

    public void get(WebDriver driver, String URL) {
        driver.get(URL);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

// Alert section
    public Alert waitAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitAlertPresence(driver).dismiss();
    }

    public String getTextAlert(WebDriver driver) {
        return waitAlertPresence(driver).getText();
    }

    public void sendkeyToAlert(WebDriver driver, String key) {
        waitAlertPresence(driver).sendKeys(key);
    }

    // Window section
    public Set<String> getWindowHandles(WebDriver driver) {
        return driver.getWindowHandles();
    }

    public void switchWindowByID(WebDriver driver, String parentID) {
        for (String id : getWindowHandles(driver)) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchWindowByTitle(WebDriver driver, String expectedPageTitle) {
        for (String id : getWindowHandles(driver)) {
            driver.switchTo().window(id);

            String pageTitlle = driver.getTitle();

            if (pageTitlle.equals(expectedPageTitle)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String expectedWindow) {
        for (String id : getWindowHandles(driver)) {
            if (!id.equals(expectedWindow)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
    }

    // Web Element Function

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByXpath(locator));
    }

    public List<WebElement> getElements(WebDriver driver, String locator) {
        return driver.findElements(getByXpath(locator));
    }

   public void clickToElement(WebDriver driver, String locator) {
       getElement(driver, locator).click();
    }

    public void sendkeyToElement(WebDriver driver, String locator, String key) {
        getElement(driver, locator).sendKeys(key);
    }

    public void selectItemInDropdown(WebDriver driver, String dropdownLocator, String expectedItem) {
        new Select(getElement(driver, dropdownLocator))
                .selectByVisibleText(expectedItem);
    }

    public String getSelectedItemInDropdown(WebDriver driver, String dropdownLocator) {
        return new Select(getElement(driver, dropdownLocator))
                .getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple (WebDriver driver, String dropdownLocator) {
        return new Select(getElement(driver, dropdownLocator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }
    }

    public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
        return getElement(driver,locator).getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver,locator).getText();
    }

    public String getCssValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver,locator).getCssValue(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getListNumberOfElements(WebDriver driver, String locator) {
        return getElements(driver,locator).size();
    }

    public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
        if(!getElement(driver,locator).isSelected()) {
            getElement(driver,locator).click();
        }
    }

    public void unheckTheCheckbox(WebDriver driver, String locator) {
        if(getElement(driver,locator).isSelected()) {
            getElement(driver,locator).click();
        }
    }

    public boolean isControlDisplayed(WebDriver driver, String locator) {
        return getElement(driver,locator).isDisplayed();
    }

    public boolean isControlSelected(WebDriver driver, String locator) {
        return getElement(driver,locator).isSelected();
    }

    public boolean isControlEnabled(WebDriver driver, String locator) {
        return getElement(driver,locator).isEnabled();
    }

    public void switchToIframe(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver,locator));
    }

    // Actions Section
    public void switchToDefaultPage(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getElement(driver,locator)).perform();
    }

    public void hoverMouseToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver,locator)).perform();
    }

    public void clickToElementByAction(WebDriver driver, String locator) {
        new Actions(driver).click(getElement(driver,locator)).perform();
    }

    public void clickAndHoldElementByAction(WebDriver driver, String locator) {
        new Actions(driver).clickAndHold(getElement(driver,locator)).perform();
    }

    public void releaseLeftMouseByAction(WebDriver driver) {
        new Actions(driver).release().perform();
    }

    public void rightClick(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }

    public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();;
    }

    public void scrollToElement(WebDriver driver, String locator) {
        new Actions(driver).scrollToElement(getElement(driver,locator)).perform();
    }

    public void sendKeyboardToElement(WebDriver driver, String locator, String key) {
        new Actions(driver).sendKeys(getElement(driver,locator), key).perform();
    }

    // Upload File(s) Section
    public void uploadSingleFile(WebDriver driver, String inputLocator, String filePath) {
        getElement(driver,inputLocator).sendKeys(filePath);
    }

    public void uploadMultipleFiles(WebDriver driver, String inputLocator, String[] filesPath) {
        int numberOfFiles = filesPath.length;
        String filePath = "";
        for (int i = 0; i <= numberOfFiles; i++) {
            if(i == 0  || i == numberOfFiles) {
                filePath = filesPath[i];
            } else {
                filePath = filesPath[i];
            }
        }
        getElement(driver,inputLocator).sendKeys();
    }

    // Javascript Executor Section
    public void executeJavascriptToBrowser(WebDriver driver, String jsScript) {
        ((JavascriptExecutor) driver).executeScript(jsScript);
    }

    public void executeJavascriptToElement(WebDriver driver, String locator, String jsScript) {
        ((JavascriptExecutor) driver).executeScript(jsScript, getElement(driver, locator));
    }

    public void clickToElementTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", getElement(driver, locator));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void scrollToElementTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", getElement(driver, locator));
    }

    public void scrollToElementBottomByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false)", getElement(driver, locator));
    }

    public void hightlightElementByJS(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript ("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments [1])", element, originalStyle);
    }

    public void setAttributeinDOMByJS(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('"
                + attributeName + "', '" + attributeValue + "' )", getElement(driver, locator));
    }

    public String getAttributeinDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }
    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + value + "');", getElement(driver, locator));
    }

    public void removeAttributeinDOMByJS(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('"
                + attributeName + "', '" + attributeValue + "' )", getElement(driver, locator));
    }

    public boolean checkImageLoadedByJS(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, locator));
    }

    public void verifyTextInInnerTectByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
    }

    public Object getElementValidationMessageByJS(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].validationMessage", getElement(driver, locator));
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitForListElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
    }

    public void waitForElementSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeSelected(getByXpath(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }

//    public void waitForListElementInvisible(WebDriver driver, String locator) {
//        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
//    }

    public void waitForElementPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
    }

    public void waitForListElementPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(locator)));
    }

    public void waitForAlertPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }

    public RewardPointPageObject openRewardPointPage(WebDriver driver) {
        waitForElementClickable(driver, SidebarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, SidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getRewardPointPage(driver);
    }

    public AddressPageObject openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, SidebarPageUI.ADDRESS_LINK);
        clickToElement(driver, SidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getAddressPage(driver);
    }

    public OrderPageObject openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, SidebarPageUI.ORDER_LINK);
        clickToElement(driver, SidebarPageUI.ORDER_LINK);
        return PageGenerator.getOrderPage(driver);
    }

    public CustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
        waitForElementClickable(driver, SidebarPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, SidebarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getCustomerInfoPage(driver);
    }
}
