package Tests;

import Pages.AlertTestPage;
import Pages.CommonPage;
import Pages.HomePage;
import SharedData.Hooks;
import org.testng.annotations.Test;

public class AlertTest extends Hooks {

    CommonPage commonPage;
    HomePage homePage;
    AlertTestPage alertTestPage;

    @Test
    public void automationMethod() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        alertTestPage = new AlertTestPage(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");

        commonPage.goToDesiredSubMenu("Alerts");

        alertTestPage.clickAlertOkButton();

        alertTestPage.clickAlertDelayButton();

        alertTestPage.clickAlertConfirmationButton();

        String alertPromptElementValue = "Mihaela";
        alertTestPage.clickAlertPromptButton(alertPromptElementValue);

    }
}
