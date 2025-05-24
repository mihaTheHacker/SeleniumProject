package Pages;

import static org.testng.Assert.assertNotNull;

import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import HelperMethods.JavascriptMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage extends CommonPage{

    @FindBy(id="frame1")
    WebElement frame1;
    @FindBy(id="frame2")
    WebElement frame2;
    @FindBy(id="sampleHeading")
    WebElement sampleHeadingElement;

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void switchToFrame1() {
        framesMethods.switchToFrame(frame1);
    }
    public void switchToFrame2() {
        framesMethods.switchToFrame(frame2);
    }
    public void verifySampleHeadingText(String expectedText) {
        assertNotNull(sampleHeadingElement, "Elementul nu a fost gasit in frame-ul 1");
        //verificam ca textul din frame este corect
        String sampleHeading = sampleHeadingElement.getText();
        assert sampleHeading.equals(expectedText) : "Textul din frame-ul 1 nu este corect. Expected: " + expectedText + ", Actual: " + sampleHeading;

    }

}
