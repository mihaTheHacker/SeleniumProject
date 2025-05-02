package HelperMethods;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertMethods {

    WebDriver driver;

    public AlertMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void interractWithAlertOK() {
        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();

    }

    public void explicitAlertWait() {
        //definim un wait explicit ca sa astepte dupa alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void interractWithDelayAlert() {
        explicitAlertWait();
        Alert alertDelayOk = driver.switchTo().alert();
        alertDelayOk.accept();

    }
    public void interractWithAlertDismiss() {
        Alert alertConfirmation = driver.switchTo().alert();
        alertConfirmation.dismiss();
    }
}
