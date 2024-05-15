package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    String name_of_folder = "Learning programming";

    @Test
    public void testSaveTwoArticleAndDeleteOne()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        String title_article_one = "British journalist";
        String title_article_two = "British archaeologist";
        String name_of_folder = "British famous people";

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Dilys Powell");
        SearchPageObject.clickByArticleWithSubstring(title_article_one);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();

        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Humfry Payone");
        SearchPageObject.clickByArticleWithSubstring(title_article_two);
        ArticlePageObject.waitForTitleElement();

        ArticlePageObject.addArticleToMyListToFolderByName(name_of_folder);
        ArticlePageObject.closeArticle();

        //NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete(title_article_one);

        MyListsPageObject.waitForArticleAppearByTitle(title_article_two);
        String title_expected = MyListsPageObject.getArticleTitleMyList();
        MyListsPageObject.clickArticleByTitle(title_article_two);

        String title_result = ArticlePageObject.getArticleTitle();
        assertEquals(
                "Article title " + title_result + "cannot expected",
                title_expected,
                title_result
        );
    }
}

