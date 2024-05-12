package tests;

import junit.framework.TestCase;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

    @Test
    public void testSwipeArticle()
    {
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.click_button_skip();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Appium";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring("Automation for Apps");
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter();
    }


    @Test
    public void testAssertArticleTitle() {
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.click_button_skip();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.assertArticleTitlePresent();
    }
}

