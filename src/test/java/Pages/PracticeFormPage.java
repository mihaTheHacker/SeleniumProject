package Pages;

import ObjectData.PracticeFormObject;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage extends CommonPage {

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


    public void completeFirstRegion(PracticeFormObject practiceFormObject) {
        elementsMethods.fillElement(firstNameField, practiceFormObject.getFirstName());
        elementsMethods.fillElement(lastNameField, practiceFormObject.getLastName());
        elementsMethods.fillElement(userEmailField, practiceFormObject.getEmail());
        elementsMethods.fillElement(userNumberField, practiceFormObject.getMobileNumber());
        elementsMethods.fillElement(currentAddressField, practiceFormObject.getcurrentAddress());

    }

    public void completeGender(PracticeFormObject practiceFormObject) {
        switch (practiceFormObject.getGender()) {
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

    public void completeSubjectWithList(PracticeFormObject practiceFormObject) {
        elementsMethods.clickElement(subjectsField);
        elementsMethods.fillMultipleValues(subjectsField, practiceFormObject.getSubject());

    }

    public void completeHobbies(PracticeFormObject practiceFormObject) {
        List<WebElement> hobbiesList = new ArrayList<>();
        hobbiesList.add(SportsHobbyElement);
        hobbiesList.add(ReadingHobbyElement);
        hobbiesList.add(MusicHobbyElement);
        elementsMethods.clickMultipleValues(hobbiesList, practiceFormObject.getHobbies());
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

    public void selectState(PracticeFormObject practiceFormObject) {
        javascriptMethods.sendKeys(practiceFormObject.getState(), stateElement);
    }

    public void selectCity(PracticeFormObject practiceFormObject) {
        javascriptMethods.sendKeys(practiceFormObject.getCity(), cityElement);
    }
}
