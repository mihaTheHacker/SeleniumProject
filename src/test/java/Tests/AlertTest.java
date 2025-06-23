package Tests;

import Pages.AlertTestPage;
import Pages.CommonPage;
import Pages.HomePage;
import SharedData.Hooks;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
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
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Alerts, Frame & Windows menu");

        commonPage.goToDesiredSubMenu("Alerts");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Alerts sub-menu");

        alertTestPage.clickAlertOkButton();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user deals with ok alert");
        alertTestPage.clickAlertDelayButton();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user deals with delay alert");
        alertTestPage.clickAlertConfirmationButton();
        String alertPromptElementValue = "Mihaela";
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user deals with confirmationDismiss alert");
        alertTestPage.clickAlertPromptButton(alertPromptElementValue);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user deals with prompt alert");

    }
}
