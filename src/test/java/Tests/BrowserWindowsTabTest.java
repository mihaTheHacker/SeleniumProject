package Tests;

import HelperMethods.WindowsMethods;
import Pages.BrowserWindowsTabPge;
import Pages.CommonPage;
import Pages.HomePage;
import SharedData.SharedData;
import org.testng.annotations.Test;

public class BrowserWindowsTabTest extends SharedData {

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


        //facem un scroll in jos
//        javascriptMethods.jsScrollDown(0, 400);
//
//        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        elementsMethods.clickElement(alertFrameWindowElement);
        homePage.goToDesiredMenu("Alerts, Frame & Windows");

//        WebElement browserWindowsElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
//        elementsMethods.clickElement(browserWindowsElement);
        commonPage.goToDesiredSubMenu("Browser Windows");

        browserWindowsTabpge.doNewTabTest();

//        WebElement tabElement = driver.findElement(By.id("tabButton"));
//        elementsMethods.clickElement(tabElement);

//        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabList.get(1));

//        WebElement sampleHeadingElement = driver.findElement(By.id("sampleHeading"));
//        System.out.println("Textul din new tab este:  " + sampleHeadingElement.getText());
//        windowsMethods.closeWindow();
//
//        driver.switchTo().window(tabList.get(0));

        browserWindowsTabpge.doNewWindowTest();
//        WebElement windowButtonElement = driver.findElement(By.id("windowButton"));
//        elementsMethods.clickElement(windowButtonElement);

//        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(windowList.get(1));

//        WebElement windowButtonElement = driver.findElement(By.id("messageWindowButton"));
//        elementsMethods.clickElement(windowButtonElement);
//        windowsMethods.switchToWindowByIndex(1);
//        WebElement bodyElement = driver.findElement(By.cssSelector("body"));
//        System.out.println("Mesajul din new window este:  " + bodyElement.getText());
//        windowsMethods.closeWindow();
//        windowsMethods.switchToWindowByIndex(0);

    }
}
