package Tests;

import ObjectData.WebTableObject;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.WebTablePage;
import PropertyUtility.PropertyUtility;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import SharedData.Hooks;
import org.testng.annotations.Test;

public class WebTableTest extends Hooks {

    HomePage homePage;
    CommonPage commonPage;
    WebTablePage webTablePage;

    @Test
    public void automationMethod() {

        PropertyUtility propertyUtility = new PropertyUtility("WebTableTest");
        WebTableObject webTableObject = new WebTableObject(propertyUtility.getData());

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        webTablePage = new WebTablePage(getDriver());


        homePage.goToDesiredMenu("Elements");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Elements menu");
        commonPage.goToDesiredSubMenu("Web Tables");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Web Tables sub-menu");
        webTablePage.completeRegistrationForm(webTableObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user fills in the registration form");

    }

}