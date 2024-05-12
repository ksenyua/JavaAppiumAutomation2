package tests;

import lib.CoreTestCase;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase {

    @Test
    public void testSearch()
    {
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.click_button_skip();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    @Test
    public void testCheckCancelSearch(){
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.click_button_skip();
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        String search_line = "Java";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmmountOfFoundArticle();
        assertTrue(
                "Find results less than 2",
                amount_of_search_results >=2
        );
        SearchPageObject.clickCancelSearch();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }
}

