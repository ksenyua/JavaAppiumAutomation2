package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class iOSMyListsPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name, '{TITLE}')]";
        CLOSE_SYNC_POPUP = "id:Close";
        SWIPE_ACTION_DELETE_BUTTON = "id:swipe action delete";
    }

    public iOSMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
