package Pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeFormPage extends CommonPage{

    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "userEmail")
    WebElement userEmailField;

    @FindBy(id = "userNumber")
    WebElement userNumberField;

//    @FindBy(xpath = "//div[@id='subjectsContainer']")
//    WebElement subjectsField;
    @FindBy(id = "subjectsInput")
    WebElement subjectsField;

    @FindBy(css = "input[placeholder='Mobile Number']")
    WebElement mobileNumberField;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleElement;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleElement;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherElement;

    @FindBy(id = "currentAddress")
    WebElement currentAddressField;

    @FindBy(id = "uploadPicture")
    WebElement pictureElement;

    @FindBy(id = "react-select-3-input")
    WebElement stateElement;

    @FindBy(id = "react-select-4-input")
    WebElement cityElement;

    @FindBy(id = "submit")
    WebElement submitButtonElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement SportsHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement ReadingHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement MusicHobbyElement;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }


    public void completeFirstRegion(String firstName, String lastName, String email, String mobileNumber, String currentAddress) {
        elementsMethods.fillElement(firstNameField, firstName);
        elementsMethods.fillElement(lastNameField, lastName);
        elementsMethods.fillElement(userEmailField, email);
        elementsMethods.fillElement(userNumberField, mobileNumber);
        elementsMethods.fillElement(currentAddressField, currentAddress);

    }

    public void completeGender(String gender) {
        switch (gender) {
            case "Male":
                elementsMethods.clickElement(maleElement);
                break;
            case "Female":
                elementsMethods.clickElement(femaleElement);
                break;
            case "Other":
                elementsMethods.clickElement(otherElement);
                break;
        }

    }

    public void completeSubject(String subject) {
        elementsMethods.clickElement(subjectsField);
        elementsMethods.fillWithActions(subjectsField, subject);
    }

    public void completeSubjectWithList(List<String> list) {
        elementsMethods.clickElement(subjectsField);
        elementsMethods.fillMultipleValues(subjectsField, list);

    }

    public void completeHobbies(List<String> hobbies) {
        List<WebElement> hobbiesList = new ArrayList<>();
        hobbiesList.add(SportsHobbyElement);
        hobbiesList.add(ReadingHobbyElement);
        hobbiesList.add(MusicHobbyElement);
        elementsMethods.clickMultipleValues(hobbiesList, hobbies);
    }

    public void fillFirstName(String firstName) {
        elementsMethods.fillElement(firstNameField, firstName);
    }

    public void fillLastName(String lastName) {
        elementsMethods.fillElement(lastNameField, lastName);
    }
    public void fillEmail(String email) {
        elementsMethods.fillElement(userEmailField, email);
    }
    public void fillMobileNumber(String mobileNumber) {
        elementsMethods.fillElement(userNumberField, mobileNumber);
    }
    public void fillCurrentAddress(String currentAddress) {
        elementsMethods.fillElement(currentAddressField, currentAddress);
    }
    public void uploadPicture() {
        elementsMethods.uploadPicture(pictureElement);
    }
    public void selectState(String state) {
        javascriptMethods.sendKeys(state, stateElement);
    }
    public void selectCity(String city) {
        javascriptMethods.sendKeys(city, cityElement);
    }
}
