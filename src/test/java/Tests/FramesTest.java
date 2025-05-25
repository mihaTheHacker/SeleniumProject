package Tests;


import HelperMethods.FramesMethods;
import Pages.CommonPage;
import Pages.FramesPage;
import Pages.HomePage;
import SharedData.SharedData;
import org.testng.annotations.Test;

public class FramesTest extends SharedData {

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
        commonPage.goToDesiredSubMenu("Frames");
        framesPage.switchToFrame1();
        String expectedText = "This is a sample page";
        framesPage.verifySampleHeadingText(expectedText);
        framesMethods.switchToDefaultFrame();
        framesPage.switchToFrame2();

    }
}