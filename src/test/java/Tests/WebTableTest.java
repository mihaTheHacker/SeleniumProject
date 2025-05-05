package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTableTest {
    //am declarat driverul de tip WebDriver
    public WebDriver driver;
    // am declarat variabila de tip JavascriptMethods
    public JavascriptMethods javascriptMethods;
    //am declarat variabila de tip ElementsMethods
    public ElementsMethods elementsMethods;

    @Test
    public void automationMethod(){

        //deschidem un browser de Chrome
        //initializam obiectul driver
        driver = new ChromeDriver();
        //initializam obiectul javascriptMethods
        javascriptMethods = new JavascriptMethods(driver);
        //initializam obiectul elementsMethods
        elementsMethods = new ElementsMethods(driver);

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll in jos
        javascriptMethods.jsScrollDown(0,400);

        //declaram un element
        WebElement elementsField = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMethods.clickElement(elementsField);

        WebElement webTableField = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementsMethods.clickElement(webTableField);

        List<WebElement> tableElements = driver.findElements(By.xpath("//div[@class='rt-body']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer actualTableSize = tableElements.size();

        WebElement addNewRecordButtonField = driver.findElement(By.id("addNewRecordButton"));
        elementsMethods.clickElement(addNewRecordButtonField);

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue = "Mihaela";
        firstNameField.sendKeys(firstNameValue);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue = "Test";
        lastNameField.sendKeys(lastNameValue);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailValue = "tralala@gmail.com";
        emailField.sendKeys(emailValue);

        WebElement ageField = driver.findElement(By.id("age"));
        String ageValue = "30";
        ageField.sendKeys(ageValue);

        WebElement salaryField = driver.findElement(By.id("salary"));
        String salaryValue = "1000";
        salaryField.sendKeys(salaryValue);

        WebElement departmentField = driver.findElement(By.id("department"));
        String departmentValue = "QA";
        departmentField.sendKeys(departmentValue);

        WebElement submitButtonField = driver.findElement(By.id("submit"));
        elementsMethods.clickElement(submitButtonField);

        List<WebElement> expectedTableElements = driver.findElements(By.xpath("//div[@class='rt-body']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));

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

    }

}