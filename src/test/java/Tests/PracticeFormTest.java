package Tests;

import ObjectData.PracticeFormObject;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.PracticeFormPage;
import PropertyUtility.PropertyUtility;
import SharedData.Hooks;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import org.testng.annotations.Test;

public class PracticeFormTest extends Hooks {

    HomePage homePage;
    CommonPage commonPage;
    PracticeFormPage practiceFormPage;


    @Test
    public void automationMethod() {

        PropertyUtility propertyUtility = new PropertyUtility("PracticeFormTest");
        PracticeFormObject practiceFormObject = new PracticeFormObject(propertyUtility.getData());

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        practiceFormPage = new PracticeFormPage(getDriver());

        homePage.goToDesiredMenu("Forms");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Forms sub-menu");
        commonPage.goToDesiredSubMenu("Practice Form");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Practice Form sub-menu");
        practiceFormPage.completeFirstRegion(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user fills in the first region of the form");
        practiceFormPage.completeGender(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user fills in the Gender field of the form");
        practiceFormPage.completeSubjectWithList(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user fills in the Subjects field of the form");
        practiceFormPage.completeHobbies(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user fills in the Hobbies field of the form");
        practiceFormPage.uploadPicture();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user uploads a picture");
        practiceFormPage.selectState(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects the State field of the form");
        practiceFormPage.selectCity(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user selects the City field of the form");
        practiceFormPage.clickSubmitButton();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user clicks the Submit button");

    }


}