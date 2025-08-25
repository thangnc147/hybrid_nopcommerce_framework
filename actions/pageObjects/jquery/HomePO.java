package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.HomePageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePO extends BasePage {
    private WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageByNumber(String number) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_LINK, number);
        clickToElement(driver, HomePageUI.DYNAMIC_PAGE_LINK, number);
    }

    public boolean isPageNumberActive(String number) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_PAGE_LINK, number);
        return getAttributeValue(driver, HomePageUI.DYNAMIC_PAGE_LINK,"class", number).endsWith("active");
    }

    public void enterToTextboxByColumnName(String columnName, String value) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_NAME, columnName);
        sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_NAME, value, columnName);
        pressKeyboardToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_NAME, Keys.ENTER, columnName);
    }

    public boolean isRowValueDisplayed(String females, String country, String males, String total) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_DATA_ON_ROW, females, country, males, total);
        return isControlDisplayed(driver, HomePageUI.DYNAMIC_DATA_ON_ROW, females, country, males, total);
    }

    public void deleteRowByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_DELETE_BUTTONBY_COUNTRY, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_DELETE_BUTTONBY_COUNTRY, countryName);
    }

    public void clickEditButtonByCountryName(String countryName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY, countryName);
    }

    public void clickToLoadDataButton() {
        waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
    }


    public void enterToTextboxByIndex(String rowIndex, String columnName, String valueToSendkey) {
        // Get Column Index
        int columnIndexNumber = getListElements(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;

        // Convert into String
        String columnIndex = String.valueOf(columnIndexNumber);

        // Sendkey to textbox by rowIndex and columnIndex
        sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX, valueToSendkey, rowIndex, columnIndex);

    }

    public void selectToDropdownByIndex(String rowIndex, String columnName, String valueToSelect) {
        // Get Column Index
        int columnIndexNumber = getListElements(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;

        // Convert into String
        String columnIndex = String.valueOf(columnIndexNumber);

        // Sendkey to textbox by rowIndex and columnIndex
        selectItemInDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX, valueToSelect, rowIndex, columnIndex);
    }

    public void checkToCheckboxByIndex(String rowIndex, String columnName, boolean checkboxStatus) {
        // Get Column Index
        int columnIndexNumber = getListElements(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName).size() + 1;

        // Convert into String
        String columnIndex = String.valueOf(columnIndexNumber);

        // Sendkey to textbox by rowIndex and columnIndex
        if (checkboxStatus) {
            checkTheCheckboxOrRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
        } else {
            unheckTheCheckbox(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
        }
    }

    public void clickToIconByIndex(String rowIndex, String actionButton) {
        clickToElement(driver, HomePageUI.DYNAMIC_ACTION_BUTTON_BY_NAME, rowIndex, actionButton);
    }

    public List<String> getAllValueOfColumn(String columnName) {
        List <String> allTextValue = new ArrayList<String>();

        // Get Column Index
        int columnIndexNumber = getListElements(driver, HomePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER_2, columnName).size() + 1;

        // Convert into String
        String columnIndex = String.valueOf(columnIndexNumber);

        List<WebElement> allValueAtColumn = getListElements(driver, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX, columnIndex);

        for (WebElement element : allValueAtColumn) {
            allTextValue.add(element.getText());
        }

//        Sort ASC

        return allTextValue;
    }

    public List<String> getAllValueOfRow(String rowIndex) {
        List <String> allTextValue = new ArrayList<String>();

        List<WebElement> allValueAtColumn = getListElements(driver, HomePageUI.ALL_VALUE_BY_ROW_INDEX, rowIndex);

        for (WebElement element : allValueAtColumn) {
            allTextValue.add(element.getText());
        }

        return allTextValue;
    }

    public boolean isFileLoadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_LOADED_BY_FILE_NAME, fileName);
        return isControlDisplayed(driver, HomePageUI.FILE_LOADED_BY_FILE_NAME, fileName);
    }

    public void clickToUploadButton(WebDriver driver) {
        List<WebElement> uploadButtons = getListElements(driver, HomePageUI.UPLOAD_BUTTON);
        for (WebElement button : uploadButtons) {
            button.click();
        }
    }

    public boolean isFileUploadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_UPLOADED_BY_FILE_NAME, fileName);
        return isControlDisplayed(driver, HomePageUI.FILE_UPLOADED_BY_FILE_NAME, fileName);
    }
}
