package SharedData;

import SharedData.browser.BrowserFactory;
import logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SharedData {

    private WebDriver driver;



    public void prepareBrowser() {

        driver = new BrowserFactory().getBrowserFactory();
        LoggerUtility.infoLog("The browser was open with success");

    }

    public void closeBrowser() {
        driver.quit();
        LoggerUtility.infoLog("The browser was closed with success");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
