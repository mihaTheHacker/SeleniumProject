package Tests;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AlertTest {

    public WebDriver driver;


    @Test
    public void automationMethod() {

        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //definim un wait implicit pentru un interval maxim de timp

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll in jos
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFrameWindowElement.click();

        WebElement alertElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertElement.click();

        WebElement alertOkElement = driver.findElement(By.id("alertButton"));
        alertOkElement.click();

        Alert alertOk = driver.switchTo().alert();
        //ne mutam cu focusul pe alerta
        alertOk.accept();

        WebElement alertDelayOkElement = driver.findElement(By.id("timerAlertButton"));
        alertDelayOkElement.click();

        //definim un wait explicit ca sa astepte dupa alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertDelayOk = driver.switchTo().alert();
        alertDelayOk.accept();

        WebElement alertConfirmationElement = driver.findElement(By.id("confirmButton"));
        alertConfirmationElement.click();

        Alert alertConfirmation = driver.switchTo().alert();
        alertConfirmation.dismiss();

        WebElement alertPromtElement = driver.findElement(By.id("promtButton"));
        alertPromtElement.click();

        Alert alertPromt = driver.switchTo().alert();
        alertPromt.sendKeys("Mihaela");
        alertPromt.accept();

    }
}
