package SharedData;

import SharedData.browser.BrowserFactory;
import configFile.ConfigFile;
import configFile.configNode.ConfigurationNode;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
