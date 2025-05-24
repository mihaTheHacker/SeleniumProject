package Pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage extends CommonPage{

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

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

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
