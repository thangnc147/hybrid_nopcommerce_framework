package com.jquery;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.PageGenerator;
import pageObjects.jquery.HomePO;

import java.util.Random;

public class Level_11_DataTable extends BaseTest {
//    private WebDriver driver;
    private HomePO homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {

        driver = getBrowserDriver(browserName, url);

        homePage = PageGenerator.getHomePage(driver);

    }


    @Test
    public void TC_01_Table_Switch_Page() {
        // Navigate to any page (paging)
        homePage.openPageByNumber("15");
        Assert.assertTrue(homePage.isPageNumberActive("15"));

        homePage.openPageByNumber("5");
        Assert.assertTrue(homePage.isPageNumberActive("5"));

        homePage.openPageByNumber("11");
        Assert.assertTrue(homePage.isPageNumberActive("11"));
    }

    @Test
    public void TC_02_Table_Search() {
        homePage.refreshCurrentPage(driver);

        // Enter to header textbox
        homePage.enterToTextboxByColumnName("Females", "12253515");

        // Verify data after searched
        Assert.assertTrue(homePage.isRowValueDisplayed("12253515", "AFRICA", "12599691", "24853148"));
        homePage.refreshCurrentPage(driver);

        // Other Examples:
        homePage.enterToTextboxByColumnName("Country", "Afghanistan");
        Assert.assertTrue(homePage.isRowValueDisplayed("384187", "Afghanistan", "407124", "791312"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxByColumnName("Males", "803");
        Assert.assertTrue(homePage.isRowValueDisplayed("777", "Antigua and Barbuda", "803", "1580"));
        homePage.refreshCurrentPage(driver);
    }

    @Test
    public void TC_03_Table_Delete_Edit_Data() {
        // Click Delete button
        homePage.enterToTextboxByColumnName("Country", "Afghanistan");
        homePage.deleteRowByCountryName("Afghanistan");
        homePage.refreshCurrentPage(driver);

        // Click Edit button
        homePage.enterToTextboxByColumnName("Country", "Afghanistan");
        homePage.clickEditButtonByCountryName("Afghanistan");
        homePage.refreshCurrentPage(driver);
    }

    @Test
    public void TC_04_Table_Get_All_Value_Row_Or_Column() {
        homePage.getAllValueOfColumn("Country");
        System.out.println(homePage.getAllValueOfColumn("Country"));

        homePage.getAllValueOfRow("5");
        System.out.println(homePage.getAllValueOfRow("5"));
    }

    @Test
    public void TC_05_Table_Action_By_Index() {
        homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");

        homePage.clickToLoadDataButton();

        homePage.enterToTextboxByIndex("4", "Contact Person", "Thang Nguyen");
        homePage.enterToTextboxByIndex("2", "Company", "Leo Nguyen");

        homePage.selectToDropdownByIndex("6", "Country", "Hong Kong");
        homePage.selectToDropdownByIndex("8", "Country", "United States");

        homePage.checkToCheckboxByIndex("5", "NPO?", false);
        homePage.checkToCheckboxByIndex("6", "NPO?", true);

        homePage.clickToIconByIndex("8", "Move Up");
        homePage.clickToIconByIndex("3", "Remove");
        homePage.clickToIconByIndex("4", "Insert");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
