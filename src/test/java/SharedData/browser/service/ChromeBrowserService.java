package SharedData.browser.service;

import configFile.configNode.DriverConfigNode;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowserService implements BrowserService {

    private WebDriver driver;

    @Override
    public void openBrowser(DriverConfigNode driverConfigNode) {
        ChromeOptions options = (ChromeOptions) getBrowserOptions(driverConfigNode);
        driver = new ChromeDriver(options);
        driver.get(driverConfigNode.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Override
    public Object getBrowserOptions(DriverConfigNode driverConfigNode) {
        ChromeOptions options = new ChromeOptions();

        if (!driverConfigNode.headless.isEmpty()) {
            options.addArguments(driverConfigNode.headless);
        }
        options.addArguments(driverConfigNode.resolution);
        options.addArguments(driverConfigNode.gpu);
        options.addArguments(driverConfigNode.extensions);
        return options;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
