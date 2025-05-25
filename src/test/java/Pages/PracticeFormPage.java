package Pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage extends CommonPage{

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "userEmail")
    private WebElement userEmailField;

    @FindBy(id = "userNumber")
    private WebElement userNumberField;

//    @FindBy(xpath = "//div[@id='subjectsContainer']")
//    WebElement subjectsField;
    @FindBy(id = "subjectsInput")
    private WebElement subjectsField;

    @FindBy(css = "input[placeholder='Mobile Number']")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement maleElement;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    private WebElement femaleElement;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    private WebElement otherElement;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressField;

    @FindBy(id = "uploadPicture")
    private WebElement pictureElement;

    @FindBy(id = "react-select-3-input")
    private WebElement stateElement;

    @FindBy(id = "react-select-4-input")
    private WebElement cityElement;

    @FindBy(id = "submit")
    private WebElement submitButtonElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement SportsHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    private WebElement ReadingHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    private WebElement MusicHobbyElement;

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
