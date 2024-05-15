package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "xpath://*[@resource-id='pcs-edit-section-title-description']/preceding-sibling::*[1]";
        FOOTER_ELEMENT = "xpath://android.view.View[@content-desc='View article in browser']";
        OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Add to reading list']";
        CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        SAVE_TO_MY_LIST_BUTTON = "id:org.wikipedia:id/page_save";
        ADD_TO_LIST_LINK = "xpath://*[contains(@text, 'Add to list')]";
        MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
        MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
        MY_LIST_TITLE_TPL = "xpath://*[contains(@text, '{TITLE}')]";
    }

    public AndroidArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
