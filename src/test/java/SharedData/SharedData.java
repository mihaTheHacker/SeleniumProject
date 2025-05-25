package SharedData;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SharedData {

    private WebDriver driver;

    @BeforeMethod

    public void prepareBrowser(){
        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //am apelat metoda maximize() pentru a deschide browserul in modul maximize
        driver.manage().window().maximize();
        //definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
