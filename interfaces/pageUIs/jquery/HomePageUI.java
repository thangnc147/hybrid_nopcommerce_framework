package pageUIs.jquery;

public class HomePageUI {
    public static final String DYNAMIC_PAGE_LINK = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
    public static final String DYNAMIC_TEXTBOX_BY_COLUMN_NAME = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
    public static final String DYNAMIC_DATA_ON_ROW = "xpath=//td[@data-key='females' and text()='%s']" +
            "/following-sibling::td[@data-key='country' and text()='%s']" +
            "/following-sibling::td[@data-key='males' and text()='%s']" +
            "/following-sibling::td[@data-key='total' and text()='%s']";

    public static final String DYNAMIC_DELETE_BUTTONBY_COUNTRY = "xpath=//td[@data-key='country' and text()='%s']" +
            "/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-remove-row-btn']";

    public static final String DYNAMIC_EDIT_BUTTON_BY_COUNTRY = "xpath=//td[@data-key='country' and text()='%s']" +
            "/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-edit-row-btn']";

    public static final String LOAD_DATA_BUTTON = "css=button#load";
    public static final String DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER = "xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]/input";
    public static final String DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//select";
    public static final String DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//input";
    public static final String DYNAMIC_ACTION_BUTTON_BY_NAME = "xpath=//tr[%s]/td//button[contains(@title, '%s')]";

    public static final String DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER_2 = "xpath=//div[text()='%s']/ancestor::th/preceding-sibling::th";
    public static final String ALL_VALUE_BY_COLUMN_INDEX = "xpath=//td[%s]";
    public static final String ALL_VALUE_BY_ROW_INDEX = "xpath=//tr[%s]/td";

    public static final String UPLOAD_FILE_TYPE = "css=input[type='file']";
    public static final String FILE_LOADED_BY_FILE_NAME = "xpath=//p[@class='name' and text()='%s']";
    public static final String UPLOAD_BUTTON = "css=td>button.start";
    public static final String FILE_UPLOADED_BY_FILE_NAME = "xpath=//p[@class='name']/a[@title='%s']";
}
