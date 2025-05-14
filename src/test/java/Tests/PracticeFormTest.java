package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import Pages.CommonPage;
import Pages.HomePage;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        //facem un scroll in jos apeland metoda jsScrollDown() din clasa JavascriptMethods
//        javascriptMethods.jsScrollDown(0, 400);
//
//        // am trecut prin lista de elemente folosindu-ma de metoda ajutatoare selectElementFromListByText, am cautat si am dat click pe Forms
//        List<WebElement> list = driver.findElements(By.xpath("//div[@class='category-cards']//div[@class=\"card mt-4 top-card\"]"));
//        elementsMethods.selectElementFromListByText(list, "Forms");
        homePage.goToDesiredMenu("Forms");

//        WebElement practiceFormElement = driver.findElement(By.xpath("//span[@class='text']"));
//        elementsMethods.clickElement(practiceFormElement);
        commonPage.goToDesiredSubMenu("Practice Form");

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        elementsMethods.fillElement(firstNameField, "Mihaela");

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        elementsMethods.fillElement(lastNameField, "Test");

        WebElement userEmailField = driver.findElement(By.id("userEmail"));
        elementsMethods.fillElement(userEmailField, "mihaela@popescu.com");

        WebElement subjectsField = driver.findElement(By.id("subjectsInput"));
        String subjectsValue = "Social Studies";
        subjectsField.sendKeys(subjectsValue);
        subjectsField.sendKeys(Keys.ENTER);

        WebElement mobileNumberField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        elementsMethods.fillElement(mobileNumberField, "0723456789");

        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        elementsMethods.uploadPicture(pictureElement);

        WebElement maleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        List<WebElement> genderElement = new ArrayList<WebElement>();
        genderElement.add(femaleElement);
        genderElement.add(maleElement);
        genderElement.add(otherElement);
        elementsMethods.selectElementFromListByText(genderElement, "Female");

        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
        javascriptMethods.sendKeys("NCR", stateElement);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        javascriptMethods.sendKeys("Delhi", cityElement);

        WebElement submitButtonElement = driver.findElement(By.id("submit"));
        javascriptMethods.jsClickElement(submitButtonElement);

    }


}