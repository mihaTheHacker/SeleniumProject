package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import Pages.CommonPage;
import Pages.HomePage;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertTest {

    WebDriver driver;
    ElementsMethods elementMethods;
    AlertMethods alertMethods;
    JavascriptMethods javascriptMethods;
    CommonPage commonPage;
    HomePage homePage;

    @Test
    public void automationMethod() {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //facem browserul in modul maximize
        driver.manage().window().maximize();
        elementMethods = new ElementsMethods(driver);
        alertMethods = new AlertMethods(driver);
        javascriptMethods = new JavascriptMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

        //facem un scroll in jos
//        javascriptMethods.jsScrollDown(0, 400);
//
//        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        elementMethods.clickElement(alertFrameWindowElement);
        homePage.goToDesiredMenu("Alerts, Frame & Windows");
//
//        WebElement alertElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
//        elementMethods.clickElement(alertElement);
        commonPage.goToDesiredSubMenu("Alerts");

        WebElement alertOkElement = driver.findElement(By.id("alertButton"));
        elementMethods.clickElement(alertOkElement);

        alertMethods.interactWithAlertOK();

        WebElement alertDelayOkElement = driver.findElement(By.id("timerAlertButton"));
        elementMethods.clickElement(alertDelayOkElement);

        //definim un wait explicit ca sa astepte dupa alerta
        alertMethods.interactWithDelayAlert();

        WebElement alertConfirmationElement = driver.findElement(By.id("confirmButton"));
        elementMethods.clickElement(alertConfirmationElement);

        //alertConfirmation.dismiss();
        alertMethods.interactWithAlertDismiss();

        WebElement alertPromtElement = driver.findElement(By.id("promtButton"));
        elementMethods.clickElement(alertPromtElement);

        //trimitem textul in alerta si acceptam promptul
        alertMethods.interactWithAlertSendKeys("Mihaela");

    }
}
