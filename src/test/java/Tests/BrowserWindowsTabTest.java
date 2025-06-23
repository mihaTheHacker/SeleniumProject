package Tests;

import HelperMethods.WindowsMethods;
import Pages.BrowserWindowsTabPge;
import Pages.CommonPage;
import Pages.HomePage;
import SharedData.Hooks;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import org.testng.annotations.Test;

public class BrowserWindowsTabTest extends Hooks {

    WindowsMethods windowsMethods;
    CommonPage commonPage;
    HomePage homePage;
    BrowserWindowsTabPge browserWindowsTabpge;


    @Test
    public void automationMethod() {

        windowsMethods = new WindowsMethods(getDriver());
        commonPage = new CommonPage(getDriver());
        homePage = new HomePage(getDriver());
        browserWindowsTabpge = new BrowserWindowsTabPge(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Alerts, Frame & Windows menu");

        commonPage.goToDesiredSubMenu("Browser Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Browser Windows sub-menu");

        browserWindowsTabpge.doNewTabTest();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user opens a new tab");

        browserWindowsTabpge.doNewWindowTest();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user opens a new window");



    }
}
