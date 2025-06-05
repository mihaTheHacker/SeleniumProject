package SharedData.browser;

import SharedData.browser.service.ChromeBrowserService;
import SharedData.browser.service.EdgeBrowserService;
import configFile.ConfigFile;
import configFile.configNode.ConfigurationNode;
import java.util.Locale;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {

    public WebDriver getBrowserFactory() {

        String ciCd= System.getProperty("ciCd");
        String browser = System.getProperty("browser").toLowerCase(Locale.ROOT);

        System.out.println("UITA-TE AICI!!! " + browser);


        ConfigurationNode configurationNode = ConfigFile.createConfigNode(ConfigurationNode.class);

        if (Boolean.parseBoolean(ciCd)) {
            configurationNode.driverConfigNode.headless = "--headless";

        }
        else {
            browser = configurationNode.driverConfigNode.localBrowser;
        }
        System.out.println("UITA-TE AICI!!! " + browser);
        switch (browser){
            case BrowserType.BROWSER_CHROME:
                ChromeBrowserService chromeService = new ChromeBrowserService();
                chromeService.openBrowser(configurationNode.driverConfigNode);
                return chromeService.getDriver();
            case BrowserType.BROWSER_EDGE:
                 EdgeBrowserService edgeService = new EdgeBrowserService();
                 edgeService.openBrowser(configurationNode.driverConfigNode);
                 return edgeService.getDriver();
        }
        return null;
    }

}
