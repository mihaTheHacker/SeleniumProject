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

    //am declarat variabila WebDriver de tip driver
    WebDriver driver;
    // am declarat variabila de tip elementsMethods
    ElementsMethods elementsMethods;
    // am declarat variabila de tip JavascriptMethods
    JavascriptMethods javascriptMethods;
    HomePage homePage;
    CommonPage commonPage;
    PracticeFormPage practiceFormPage;


    @Test
    public void automationMethod() {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //am apelat metoda maximize() pentru a deschide browserul in modul maximize
        driver.manage().window().maximize();
        //initializam obiectul javascriptMethods
        elementsMethods = new ElementsMethods(driver);
        //initializam obiectul elementsMethods
        javascriptMethods = new JavascriptMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        practiceFormPage = new PracticeFormPage(driver);
        //facem un scroll in jos apeland metoda jsScrollDown() din clasa JavascriptMethods
//        javascriptMethods.jsScrollDown(0, 400);
//
        homePage.goToDesiredMenu("Forms");

//        WebElement practiceFormElement = driver.findElement(By.xpath("//span[@class='text']"));
//        elementsMethods.clickElement(practiceFormElement);
        commonPage.goToDesiredSubMenu("Practice Form");

        practiceFormPage.completeFirstRegion("Mary", "Poppins", "test@test.com", "1234567890", "Sun street");

        practiceFormPage.completeGender("Female");
//        practiceFormPage.completeSubject("English");
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

//        practiceFormPage.fillFirstName("Mihaela");
//        WebElement firstNameField = driver.findElement(By.id("firstName"));
//        elementsMethods.fillElement(firstNameField, "Mihaela");
//
        //practiceFormPage.fillLastName("Mary");
//        WebElement lastNameField = driver.findElement(By.id("lastName"));
//        elementsMethods.fillElement(lastNameField, "Test");
//
         //practiceFormPage.fillEmail("test@test.com");
//        WebElement userEmailField = driver.findElement(By.id("userEmail"));
//        elementsMethods.fillElement(userEmailField, "mihaela@popescu.com");
//
//        WebElement subjectsField = driver.findElement(By.id("subjectsInput"));
//        String subjectsValue = "Social Studies";
//        subjectsField.sendKeys(subjectsValue);
//        subjectsField.sendKeys(Keys.ENTER);

        //PracticeFormPage.fillMobileNumber("0723456789");
//        WebElement mobileNumberField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
//        elementsMethods.fillElement(mobileNumberField, "0723456789");
//
        practiceFormPage.uploadPicture();
//        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
//        elementsMethods.uploadPicture(pictureElement);
//
//        WebElement maleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
//        WebElement femaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
//        WebElement otherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
//        List<WebElement> genderElement = new ArrayList<WebElement>();
//        genderElement.add(femaleElement);
//        genderElement.add(maleElement);
//        genderElement.add(otherElement);
//        elementsMethods.selectElementFromListByText(genderElement, "Female");
//
        practiceFormPage.selectState("NCR");
//        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
//        javascriptMethods.sendKeys("NCR", stateElement);
//
        practiceFormPage.selectCity("Delhi");
//        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
//        javascriptMethods.sendKeys("Delhi", cityElement);
//
//        WebElement submitButtonElement = driver.findElement(By.id("submit"));
//        javascriptMethods.jsClickElement(submitButtonElement);

    }


}