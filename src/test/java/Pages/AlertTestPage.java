package Pages;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertTestPage {

    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;
    AlertMethods alertMethods;

    public AlertTestPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptMethods = new JavascriptMethods(driver);
        this.alertMethods = new AlertMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "alertButton")
    public static WebElement alertButton;
    @FindBy(id= "timerAlertButton")
    public static WebElement alertDelayButton;
    @FindBy(id = "confirmButton")
    public static WebElement alertConfirmationButton;
    @FindBy(id = "promtButton")
    public static WebElement alertPromptButton;

    public void clickAlertOkButton() {
        elementsMethods.clickElement(alertButton);
        alertMethods.interactWithAlertOK();
    }
    public void clickAlertDelayButton() {
        elementsMethods.clickElement(alertDelayButton);
        alertMethods.interactWithDelayAlert();
    }
    public void clickAlertConfirmationButton() {
        elementsMethods.clickElement(alertConfirmationButton);
        alertMethods.interactWithAlertDismiss();
    }
    public void clickAlertPromptButton(String keys) {
        elementsMethods.clickElement(alertPromptButton);
        alertMethods.interactWithAlertSendKeys(keys);
    }
}
