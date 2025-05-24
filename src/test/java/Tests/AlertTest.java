package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import Pages.AlertTestPage;
import Pages.CommonPage;
import Pages.HomePage;
import SharedData.SharedData;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertTest extends SharedData {

    ElementsMethods elementMethods;
    AlertMethods alertMethods;
    JavascriptMethods javascriptMethods;
    CommonPage commonPage;
    HomePage homePage;
    AlertTestPage alertTestPage;

    @Test
    public void automationMethod() {

        elementMethods = new ElementsMethods(driver);
        alertMethods = new AlertMethods(driver);
        javascriptMethods = new JavascriptMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        alertTestPage = new AlertTestPage(driver);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");

        commonPage.goToDesiredSubMenu("Alerts");

        alertTestPage.clickAlertOkButton();

        alertTestPage.clickAlertDelayButton();

        alertTestPage.clickAlertConfirmationButton();

        String alertPromptElementValue = "Mihaela";
        alertTestPage.clickAlertPromptButton(alertPromptElementValue);

    }
}
