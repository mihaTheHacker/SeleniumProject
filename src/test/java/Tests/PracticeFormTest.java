package Tests;

import ObjectData.PracticeFormObject;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.PracticeFormPage;
import PropertyUtility.PropertyUtility;
import SharedData.SharedData;
import org.testng.annotations.Test;

public class PracticeFormTest extends SharedData {

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

        commonPage.goToDesiredSubMenu("Practice Form");

        practiceFormPage.completeFirstRegion(practiceFormObject);

        practiceFormPage.completeGender(practiceFormObject);
//        List<String> subject = new ArrayList<String>();
//        subject.add("English");
//        subject.add("Maths");
//        subject.add("Social Studies");
//        javascriptMethods.jsScrollDown(0,400);
        practiceFormPage.completeSubjectWithList(practiceFormObject);
//        List<String> hobbies = new ArrayList<String>();
//        hobbies.add("Sports");
//        hobbies.add("Reading");
//        hobbies.add("Music");

        practiceFormPage.completeHobbies(practiceFormObject);

        practiceFormPage.uploadPicture();

        practiceFormPage.selectState(practiceFormObject);

        practiceFormPage.selectCity(practiceFormObject);


//        WebElement submitButtonElement = driver.findElement(By.id("submit"));
//        javascriptMethods.jsClickElement(submitButtonElement);

    }


}