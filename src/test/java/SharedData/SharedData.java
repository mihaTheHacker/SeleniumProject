package SharedData;

import SharedData.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SharedData {

    private WebDriver driver;

    @BeforeMethod

    public void prepareBrowser() {

        driver = new BrowserFactory().getBrowserFactory();

    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
