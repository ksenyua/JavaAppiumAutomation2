package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.List;

public class SearchPageObject extends MainPageObject
{
    private static final String

    SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]",
    SEARCH_INPUT = "xpath://*[@resource-id='org.wikipedia:id/search_src_text']",
    SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn",
    SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='{SUBSTRING}']",
    SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title']";

    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /*TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("", substring);
    }
    /*TEMPLATES METHODS */

    public void initSearchInput()
    {
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element", 5);
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Cancel is still present", 5);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring, 15);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring, 15);
    }

    public int getAmmountOfFoundArticle()
    {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by request",
                15
        );
        return this.getAmmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public int getAmmountOfElements(String locator){
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any result");
    }
}

