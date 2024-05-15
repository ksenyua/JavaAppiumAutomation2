package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class iOSNavigationUI extends NavigationUI {
    static {
        MY_LIST_LINK = "id:Saved";
       // HOME_LINK = "xpath://XCUIElementTypeNavigationBar[@name=\"W\"]";

    }

    public iOSNavigationUI(AppiumDriver driver) {
        super(driver);
    }
}
