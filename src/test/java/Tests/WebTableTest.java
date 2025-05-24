package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.WebTablePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTableTest {

    //am declarat driverul de tip WebDriver si variabilele pentru pagini si metode
    WebDriver driver;
    JavascriptMethods javascriptMethods;
    ElementsMethods elementsMethods;
    HomePage homePage;
    CommonPage commonPage;
    WebTablePage webTablePage;

    @Test
    public void automationMethod() {

        //deschidem un browser de Chrome
        //initializam obiectul driver
        driver = new ChromeDriver();
        javascriptMethods = new JavascriptMethods(driver);
        elementsMethods = new ElementsMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        webTablePage = new WebTablePage(driver);

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll in jos
//        javascriptMethods.jsScrollDown(0, 400);
//
//        //declaram un element
//        WebElement elementsField = driver.findElement(By.xpath("//h5[text()='Elements']"));
//        elementsMethods.clickElement(elementsField);
        homePage.goToDesiredMenu("Elements");

//        WebElement webTableField = driver.findElement(By.xpath("//span[text()='Web Tables']"));
//        elementsMethods.clickElement(webTableField);
        commonPage.goToDesiredSubMenu("Web Tables");

        List<WebElement> tableElements = driver.findElements(
                By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer actualTableSize = tableElements.size();

        String firstNameValue = "Miha";
        String lastNameValue = "Pop";
        String emailValue = "test@test.com";
        String ageValue = "30";
        String salaryValue = "1000";
        String departmentValue = "QA";
        webTablePage.completeRegistrationForm(firstNameValue, lastNameValue, emailValue, ageValue, salaryValue, departmentValue);

//        WebElement addNewRecordButtonField = driver.findElement(By.id("addNewRecordButton"));
//        elementsMethods.clickElement(addNewRecordButtonField);
//
//        WebElement firstNameField = driver.findElement(By.id("firstName"));
//        String firstNameValue = "Mihaela";
//        firstNameField.sendKeys(firstNameValue);
//
//        WebElement lastNameField = driver.findElement(By.id("lastName"));
//        String lastNameValue = "Test";
//        lastNameField.sendKeys(lastNameValue);
//
//        WebElement emailField = driver.findElement(By.id("userEmail"));
//        String emailValue = "tralala@gmail.com";
//        emailField.sendKeys(emailValue);
//
//        WebElement ageField = driver.findElement(By.id("age"));
//        String ageValue = "30";
//        ageField.sendKeys(ageValue);
//
//        WebElement salaryField = driver.findElement(By.id("salary"));
//        String salaryValue = "1000";
//        salaryField.sendKeys(salaryValue);
//
//        WebElement departmentField = driver.findElement(By.id("department"));
//        String departmentValue = "QA";
//        departmentField.sendKeys(departmentValue);
//
//        WebElement submitButtonField = driver.findElement(By.id("submit"));
//        elementsMethods.clickElement(submitButtonField);

        List<WebElement> expectedTableElements = driver.findElements(
                By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));

        Integer expectedTableSize = actualTableSize + 1;
        Assert.assertEquals(expectedTableElements.size(), expectedTableSize);

        String actualTableValue = expectedTableElements.get(3).getText();
        Assert.assertTrue(actualTableValue.contains(firstNameValue));
        Assert.assertTrue(actualTableValue.contains(lastNameValue));
        Assert.assertTrue(actualTableValue.contains(emailValue));
        Assert.assertTrue(actualTableValue.contains(ageValue));
        Assert.assertTrue(actualTableValue.contains(ageValue));
        Assert.assertTrue(actualTableValue.contains(salaryValue));
        Assert.assertTrue(actualTableValue.contains(departmentValue));

        driver.quit();

    }

}