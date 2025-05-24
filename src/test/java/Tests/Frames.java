package Tests;

import static org.testng.Assert.assertNotNull;

import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import HelperMethods.JavascriptMethods;
import Pages.CommonPage;
import Pages.FramesPage;
import Pages.HomePage;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {

    WebDriver driver;
    JavascriptMethods javascriptMethods;
    ElementsMethods elementsMethods;
    FramesMethods framesMethods;
    CommonPage commonPage;
    HomePage homePage;
    FramesPage framesPage;

    @Test
    public void automationMethod() {

        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        javascriptMethods = new JavascriptMethods(driver);
        elementsMethods = new ElementsMethods(driver);
        framesMethods = new FramesMethods(driver);
        commonPage = new CommonPage(driver);
        homePage = new HomePage(driver);
        framesPage = new FramesPage(driver);

        driver.get("https://demoqa.com/");

        //definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Frames");
        framesPage.switchToFrame1();
        String expectedText = "This is a sample page";
        framesPage.verifySampleHeadingText(expectedText);
        framesMethods.switchToDefaultFrame();
        framesPage.switchToFrame2();
        javascriptMethods.jsScrollDown(200, 200);

    }
}