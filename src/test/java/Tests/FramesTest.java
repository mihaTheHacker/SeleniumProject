package Tests;


import HelperMethods.FramesMethods;
import Pages.CommonPage;
import Pages.FramesPage;
import Pages.HomePage;
import SharedData.Hooks;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import org.testng.annotations.Test;

public class FramesTest extends Hooks {

    HomePage homePage;
    CommonPage commonPage;
    FramesMethods framesMethods;
    FramesPage framesPage;

    @Test
    public void automationMethod() {
        homePage = new HomePage(getDriver());
        framesMethods = new FramesMethods(getDriver());
        commonPage = new CommonPage(getDriver());
        framesPage = new FramesPage(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Alerts, Frame & Windows menu");
        commonPage.goToDesiredSubMenu("Frames");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Frames sub-menu");
        framesPage.switchToFrame1();
        String expectedText = "This is a sample page";
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user interacts with the first iframe");
        framesPage.verifySampleHeadingText(expectedText);
        framesMethods.switchToDefaultFrame();
        framesPage.switchToFrame2();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user interacts with the second iframe");

    }
}