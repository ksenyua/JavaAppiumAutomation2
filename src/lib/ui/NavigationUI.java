package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject{

    private static final String
            MY_LIST_LINK = "//android.widget.FrameLayout[@content-desc='My lists']";

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyLists()
    {
        this.waitForElementAndClick(
                By.xpath(MY_LIST_LINK),
                "Cannot find navigation button to My List",
                5
        );
    }

    public void click_button_skip()
    {
        this.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Skip')]"),
                "Cannot find skip button",
                5
        );
    }

}
