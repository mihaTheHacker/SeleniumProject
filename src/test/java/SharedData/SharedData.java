package SharedData;

import HelperMethods.AlertMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SharedData {

    public WebDriver driver;
    public AlertMethods alertMethods;

    @BeforeMethod

    public void prepareBrowser(){
        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        alertMethods = new AlertMethods(driver);
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //am apelat metoda maximize() pentru a deschide browserul in modul maximize
        driver.manage().window().maximize();
        //definim un wait implicit pentru un interval maxim de timp
        alertMethods.explicitAlertWait();

    }
    @AfterMethod
    public void closeBrowser() {
        //inchidem browserul
        driver.quit();
    }

}
