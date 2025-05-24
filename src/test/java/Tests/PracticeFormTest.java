package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.PracticeFormPage;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeFormTest {

    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;
    HomePage homePage;
    CommonPage commonPage;
    PracticeFormPage practiceFormPage;


    @Test
    public void automationMethod() {
        driver = new ChromeDriver();

        driver.get("https://demoqa.com/");

        driver.manage().window().maximize();
        elementsMethods = new ElementsMethods(driver);
        javascriptMethods = new JavascriptMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        practiceFormPage = new PracticeFormPage(driver);
        homePage.goToDesiredMenu("Forms");

        commonPage.goToDesiredSubMenu("Practice Form");

        practiceFormPage.completeFirstRegion("Mary", "Poppins", "test@test.com", "1234567890", "Sun street");

        practiceFormPage.completeGender("Female");
        List<String> subject = new ArrayList<String>();
        subject.add("English");
        subject.add("Maths");
        subject.add("Social Studies");

        practiceFormPage.completeSubjectWithList(subject);
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("Sports");
        hobbies.add("Reading");
        hobbies.add("Music");

        practiceFormPage.completeHobbies(hobbies);

        practiceFormPage.uploadPicture();

        practiceFormPage.selectState("NCR");

        practiceFormPage.selectCity("Delhi");


//        WebElement submitButtonElement = driver.findElement(By.id("submit"));
//        javascriptMethods.jsClickElement(submitButtonElement);

    }


}