package Tests;

import HelperMethods.ElementsMethods;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeFormTest {

    public WebDriver driver;
    public ElementsMethods elementMethods;


    @Test
    public void automationMethod() {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browserul in modul maximize
        driver.manage().window().maximize();
        elementMethods = new ElementsMethods(driver);

        //facem un scroll in jos
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");


        //declaram un element
        WebElement formElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementMethods.clickElement(formElement);

        WebElement practiceFormElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementMethods.clickElement(practiceFormElement);

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        elementMethods.fillElement(firstNameField, "Mihaela");

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        elementMethods.fillElement(lastNameField, "Test");

        WebElement userEmailField = driver.findElement(By.id("userEmail"));
        elementMethods.fillElement(userEmailField, "mihaela@popescu.com");

        WebElement subjectsField = driver.findElement(By.id("subjectsInput"));
        String subjectsValue = "Social Studies";
        subjectsField.sendKeys(subjectsValue);
        subjectsField.sendKeys(Keys.ENTER);

        WebElement mobileNumberField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        elementMethods.fillElement(mobileNumberField, "0723456789");

        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        elementMethods.uploadPicture(pictureElement);

        WebElement maleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        List<WebElement> genderElement = new ArrayList<WebElement>();
        genderElement.add(femaleElement);
        genderElement.add(maleElement);
        genderElement.add(otherElement);
        elementMethods.selectElementFromListByText(genderElement, "Female");

        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
        js.executeScript("arguments[0].click();", stateElement);
        stateElement.sendKeys("NCR");
        stateElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        js.executeScript("arguments[0].click();", cityElement);
        cityElement.sendKeys("Delhi");
        cityElement.sendKeys(Keys.ENTER);

        WebElement submitButtonElement = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submitButtonElement);

    }


}