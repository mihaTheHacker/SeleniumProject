package Tests;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeFormTest {

    public WebDriver driver;


    @Test
    public void automationMethod() {

        int x = 5; if (x > 2){

            System.out.println("Greater");

        }

        else

        { System.out.println("Smaller");}

        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browserul in modul maximize
        driver.manage().window().maximize();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
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

        WebElement subjectsField = driver.findElement(By.id("subjectsInput"));
        String subjectsValue = "Social Studies";
        subjectsField.sendKeys(subjectsValue);
        subjectsField.sendKeys(Keys.ENTER);

        WebElement mobileNumberField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileNumberValue = "0723456789";
        mobileNumberField.sendKeys(mobileNumberValue);

        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/Pixar-Wall-E.webp");
        pictureElement.sendKeys(file.getAbsolutePath());

        WebElement maleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String genderValue = "Other";

        if (femaleElement.getText().equals(genderValue)) {
            femaleElement.click();
        } else if (maleElement.getText().equals(genderValue)) {
            maleElement.click();
        } else if (otherElement.getText().equals(genderValue)) {
            otherElement.click();
        }
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