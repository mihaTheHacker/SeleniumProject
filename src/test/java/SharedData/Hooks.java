package SharedData;

import extentUtility.ExtentUtility;
import logger.LoggerUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Hooks extends SharedData {

    public String testName;

    @BeforeSuite
    public void initiateTestReport() {
        ExtentUtility.initiateReport();
    }

    @BeforeMethod
    public void prepareEnvironment() {
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTestCase(testName);
        ExtentUtility.createTest(testName);
        prepareBrowser();

    }

    @AfterMethod
    public void clearEnvironment(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String errorMessage = result.getThrowable().getMessage();
            LoggerUtility.errorLog(errorMessage);
            ExtentUtility.attachLog(testName, errorMessage, getDriver());
        }
        closeBrowser();
        LoggerUtility.endTestCase(testName);
        ExtentUtility.finishTest(testName);

    }

    @AfterSuite
    public void finalizeLogFiles() {
        LoggerUtility.mergeLogFilesIntoOne();
        ExtentUtility.generateReport();
    }
}