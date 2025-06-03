package PracticeTests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LetCodeFormsLocatorsPractice {

    @Test
    public void findLocators() {
        //1. Open the browser
        //deschidem un browser de Chrome
        ChromeDriver driver = new ChromeDriver();

        //2. Access the web page
        driver.get("https://letcode.in/forms");

        //3. Maximize the browser
        driver.manage().window().maximize();

        //4. Find the locators for the following elements:
        //a. Country code;
        WebElement countryCodeDropdown = driver.findElement(By.cssSelector("#countrycode + div.control div.select select"));
        //Create a select Object to interact with the dropdown
        Select selectCountryCode = new Select(countryCodeDropdown);

        //Get all the options from the dropdown
        List<WebElement> countryCodeOptions = selectCountryCode.getOptions();

        //Iterate through the options in the dropdown and select the one that matches the value
        for (WebElement option : countryCodeOptions) {
            String countryValue = option.getText(); //get the text of each option
            if (countryValue.equals("Romania (+40)")) {
                selectCountryCode.selectByVisibleText(countryValue); //select the option that matches the value
                break; //exit the loop
            }
        }
        //Assert that the selected value is the one we want
        String selectedCountryCode = selectCountryCode.getFirstSelectedOption().getText();
        assert selectedCountryCode.equals("Romania (+40)");

        //b. Country
        WebElement countryDropdown = driver.findElement(By.cssSelector("#country + div.control div.select select"));
        //Create a select Object to interact with the dropdown
        Select selectCountry = new Select(countryDropdown);

        //Get all the options from the dropdown
        List<WebElement> countryOptions = selectCountry.getOptions();
        //Iterate through the options in the dropdown and select the one that matches the value
        for (WebElement option : countryOptions) {
            String countryValue = option.getText(); //get the text of each option
            if (countryValue.equals("Romania")) {
                selectCountry.selectByVisibleText(countryValue); //select the option that matches the value
                break; //exit the loop
            }
        }
        //Assert that the selected value is the one we want
        String selectedCountryValue = selectCountry.getFirstSelectedOption().getText();
        assert selectedCountryValue.equals("Romania");

        //c. First name
        WebElement firstNameField = driver.findElement(By.id("firstname"));
        String firstNameValue = "Mihaela";
        firstNameField.sendKeys(firstNameValue);

        //d. Last name
        WebElement lastNameField = driver.findElement(By.id("lasttname"));
        String lastNameValue = "Test";
        lastNameField.sendKeys(lastNameValue);

        //e. Email
        WebElement emailField = driver.findElement(By.id("email"));
        String emailValue = "t@tralala.com";
        emailField.clear();
        emailField.sendKeys(emailValue);

        //f. Phone number
        WebElement phoneNumberField = driver.findElement(By.id("Phno"));
        String phoneNumberValue = "0123456789";
        phoneNumberField.sendKeys(phoneNumberValue);

        //g.Address line-1
        WebElement addressLine1Field = driver.findElement(By.id("Addl1"));
        String addressLine1Value = "Strada Primaverii";
        addressLine1Field.sendKeys(addressLine1Value);

        //h. Address line-2
        WebElement addressLine2Field = driver.findElement(By.id("Addl2"));
        String addressLine2Value = "Nr. 1";
        addressLine2Field.sendKeys(addressLine2Value);

        //i. State
        WebElement stateField = driver.findElement(By.id("state"));
        String stateValue = "Iasi";
        stateField.sendKeys(stateValue);

        //j. Postal code
        WebElement postalCodeField = driver.findElement(By.id("postalcode"));
        String postalCodeValue = "778899";
        postalCodeField.sendKeys(postalCodeValue);
    }

}