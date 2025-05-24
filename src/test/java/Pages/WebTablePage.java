package Pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage {

    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptMethods = new JavascriptMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    WebElement addNewRecordButton;
    @FindBy(id = "firstName")
    WebElement firstNameInput;
    @FindBy(id = "lastName")
    WebElement lastNameInput;
    @FindBy(id = "userEmail")
    WebElement userEmailInput;
    @FindBy(id = "age")
    WebElement ageInput;
    @FindBy(id = "salary")
    WebElement salaryInput;
    @FindBy(id = "department")
    WebElement departmentInput;
    @FindBy(id = "submit")
    WebElement submitButton;

    public void completeRegistrationForm(String firstName, String lastName, String userEmail, String age, String salary, String department) {
        elementsMethods.clickElement(addNewRecordButton);
        elementsMethods.fillElement(firstNameInput, firstName);
        elementsMethods.fillElement(lastNameInput, lastName);
        elementsMethods.fillElement(userEmailInput, userEmail);
        elementsMethods.fillElement(ageInput, age);
        elementsMethods.fillElement(salaryInput, salary);
        elementsMethods.fillElement(departmentInput, department);
        elementsMethods.clickElement(submitButton);
    }

}
