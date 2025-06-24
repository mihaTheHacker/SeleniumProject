package Pages;

import logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AlertTestPage extends CommonPage {

    @FindBy(id = "alertButton")
    private static WebElement alertButton;
    @FindBy(id= "timerAlertButton")
    private static WebElement alertDelayButton;
    @FindBy(id = "confirmButton")
    private static WebElement alertConfirmationButton;
    @FindBy(id = "promtButton")
    private static WebElement alertPromptButton;

    public AlertTestPage(WebDriver driver) {
        super(driver);
    }

    public void clickAlertOkButton() {
        elementsMethods.clickElement(alertButton);
        LoggerUtility.infoLog( "The user clicks on the Alert button");
        alertMethods.interactWithAlertOK();
        LoggerUtility.infoLog( "The user interacts with the alert by clicking OK");
    }
    public void clickAlertDelayButton() {
        elementsMethods.clickElement(alertDelayButton);
        LoggerUtility.infoLog( "The user clicks on the Alert Delay button");
        alertMethods.interactWithDelayAlert();
        LoggerUtility.infoLog( "The user interacts with the delay alert");
    }
    public void clickAlertConfirmationButton() {
        elementsMethods.clickElement(alertConfirmationButton);
        LoggerUtility.infoLog( "The user clicks on the Alert Confirmation button");
        alertMethods.interactWithAlertDismiss();
        LoggerUtility.infoLog( "The user interacts with the confirmation alert by dismissing it");
    }
    public void clickAlertPromptButton(String keys) {
        elementsMethods.clickElement(alertPromptButton);
        LoggerUtility.infoLog( "The user clicks on the Alert Prompt button");
        alertMethods.interactWithAlertSendKeys(keys);
        LoggerUtility.infoLog( "The user interacts with the prompt alert by sending keys: " + keys);
    }
}
