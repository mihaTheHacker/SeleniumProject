package Pages;

import ObjectData.WebTableObject;
import extentUtility.ReportStep;
import logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void completeRegistrationForm(WebTableObject webTableObject) {
        elementsMethods.clickElement(addNewRecordButton);
        LoggerUtility.infoLog( "The user clicks on the Add New Record button");
        elementsMethods.fillElement(firstNameInput, webTableObject.getFirstName());
        LoggerUtility.infoLog( "The user fills in the First Name field with: " + webTableObject.getFirstName());
        elementsMethods.fillElement(lastNameInput, webTableObject.getLastName());
        LoggerUtility.infoLog( "The user fills in the Last Name field with: " + webTableObject.getLastName());
        elementsMethods.fillElement(userEmailInput, webTableObject.getEmail());
        LoggerUtility.infoLog( "The user fills in the Email field with: " + webTableObject.getEmail());
        elementsMethods.fillElement(ageInput, webTableObject.getAge());
        LoggerUtility.infoLog( "The user fills in the Age field with: " + webTableObject.getAge());
        elementsMethods.fillElement(salaryInput, webTableObject.getSalary());
        LoggerUtility.infoLog( "The user fills in the Salary field with: " + webTableObject.getSalary());
        elementsMethods.fillElement(departmentInput, webTableObject.getDepartmentName());
        LoggerUtility.infoLog( "The user fills in the Department field with: " + webTableObject.getDepartmentName());
        elementsMethods.clickElement(submitButton);
        LoggerUtility.infoLog( "The user clicks on the Submit button");
    }

}
