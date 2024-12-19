package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeFormTest {

    public WebDriver driver;


    @Test
    public void automationMethod() {

        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll in jos
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        //declaram un element
        WebElement formElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formElement.click();

        WebElement practiceFormElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormElement.click();

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue = "Mihaela";
        firstNameField.sendKeys(firstNameValue);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue = "Test";
        lastNameField.sendKeys(lastNameValue);

        WebElement userEmailField = driver.findElement(By.id("userEmail"));
        String userEmailValue = "mihaela@popescu.com";
        userEmailField.sendKeys(userEmailValue);

        WebElement mobileNumberField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileNumberValue = "0723456789";
        mobileNumberField.sendKeys(mobileNumberValue);

    }
}