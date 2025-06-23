package Pages;

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
