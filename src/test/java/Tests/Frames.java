package Tests;

import static org.testng.Assert.assertNotNull;

import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import HelperMethods.JavascriptMethods;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {

    public WebDriver driver;
    public JavascriptMethods javascriptMethods;
    public ElementsMethods elementsMethods;
    public FramesMethods framesMethods;

    @Test
    public void automationMethod() {

        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        javascriptMethods = new JavascriptMethods(driver);
        elementsMethods = new ElementsMethods(driver);
        framesMethods = new FramesMethods(driver);

        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //definim un wait implicit pentru un interval maxim de timp

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll in jos
        javascriptMethods.jsScrollDown(0, 400);

        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethods.clickElement(alertFrameWindowElement);

        WebElement frameElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementsMethods.clickElement(frameElement);

        WebElement frameElement1 = driver.findElement(By.id("frame1"));
        framesMethods.switchToFrame(frameElement1);
//        driver.switchTo().frame(frameElement1);

        WebElement sampleHeadingFrameElement = driver.findElement(By.id("sampleHeading"));
//        System.out.println("Textul din new frame este: " + sampleHeadingFrameElement.getText());
        //verificam daca elementul a fost gasit(nu este null)
        assertNotNull(sampleHeadingFrameElement, "Elementul nu a fost gasit in frame-ul 1");
        //verificam ca textul din frame este corect
        String sampleHeading = sampleHeadingFrameElement.getText();
        String expectedText = "This is a sample page";
        assert sampleHeading.equals(expectedText) : "Textul din frame-ul 1 nu este corect. Expected: " + expectedText + ", Actual: " + sampleHeading;

        // revenim cu focusul la frame-ul parinte
        framesMethods.switchToDefaultFrame();
//        driver.switchTo().defaultContent();

        WebElement frameElement2 = driver.findElement(By.id("frame2"));
        framesMethods.switchToFrame(frameElement2);
//        driver.switchTo().frame(frameElement2);

        javascriptMethods.jsScrollDown(200, 200);

    }
}