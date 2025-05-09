package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import HelperMethods.WindowsMethods;
import Pages.CommonPage;
import Pages.HomePage;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserWindowsTab {

    WebDriver driver;
    JavascriptMethods javascriptMethods;
    ElementsMethods elementsMethods;
    WindowsMethods windowsMethods;
    CommonPage commonPage;
    HomePage homePage;


    @Test
    public void automationMethod() {

        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        javascriptMethods = new JavascriptMethods(driver);
        elementsMethods = new ElementsMethods(driver);
        windowsMethods = new WindowsMethods(driver);
        commonPage = new CommonPage(driver);
        homePage = new HomePage(driver);

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll in jos
//        javascriptMethods.jsScrollDown(0, 400);
//
//        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        elementsMethods.clickElement(alertFrameWindowElement);
        homePage.goToDesiredMenu("Alerts, Frame & Windows");

//        WebElement browserWindowsElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
//        elementsMethods.clickElement(browserWindowsElement);
        commonPage.goToDesiredSubMenu("Browser Windows");

        WebElement tabElement = driver.findElement(By.id("tabButton"));
        elementsMethods.clickElement(tabElement);

        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));

        WebElement sampleHeadingElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new tab este:  " + sampleHeadingElement.getText());
        windowsMethods.closeWindow();

        driver.switchTo().window(tabList.get(0));
        WebElement windowButtonElement = driver.findElement(By.id("windowButton"));
        elementsMethods.clickElement(windowButtonElement);

//        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(windowList.get(1));
        windowsMethods.switchToWindowByIndex(1);

        WebElement sampleHeadingWindowElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new window este:  " + sampleHeadingWindowElement.getText());
        windowsMethods.closeWindow();
        windowsMethods.switchToWindowByIndex(2);
    }
}
