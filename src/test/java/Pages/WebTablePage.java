package Pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage extends CommonPage{

    @FindBy(id = "addNewRecordButton")
    private WebElement addNewRecordButton;
    @FindBy(id = "firstName")
    private WebElement firstNameInput;
    @FindBy(id = "lastName")
    private WebElement lastNameInput;
    @FindBy(id = "userEmail")
    private WebElement userEmailInput;
    @FindBy(id = "age")
    private WebElement ageInput;
    @FindBy(id = "salary")
    private WebElement salaryInput;
    @FindBy(id = "department")
    private WebElement departmentInput;
    @FindBy(id = "submit")
    private WebElement submitButton;

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
