package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase {

    @Test
    public void testChangeScreenOrientationOnSearchResults() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.click_button_skip();

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        String description_before_rotation = articlePageObject.getArticleDescription();

        this.rotateScreenLandscape();

        String description_after_rotation = articlePageObject.getArticleDescription();
        assertEquals(
                "Article description have been change after rotation",
                description_before_rotation,
                description_after_rotation
        );

        this.rotateScreenPortrait();

        String description_after_second_rotation = articlePageObject.getArticleDescription();
        assertEquals(
                "Article description have been change after rotation",
                description_before_rotation,
                description_after_second_rotation
        );
    }

    @Test
    public void testCheckSearchArticleInBackground() {
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.click_button_skip();
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForSearchResult("Object-oriented programming language");
        this.backgroundApp(2);
        searchPageObject.waitForSearchResult("Object-oriented programming language");
    }
}
