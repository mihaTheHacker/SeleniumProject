package SharedData;

import logger.LoggerUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends SharedData {

    public String testName;

    @BeforeMethod
    public void prepareEnvironment() {
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTestCase(testName);
        prepareBrowser();

    }

    @AfterMethod
    public void clearEnvironment() {
        closeBrowser();
        //pentru moment toate sunt bune
        LoggerUtility.endTestCase(testName);

    }
}