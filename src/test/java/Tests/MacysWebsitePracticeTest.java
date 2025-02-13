package Tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MacysWebsitePracticeTest {

    public WebDriver driver;


    @Test
    public void macysAddToCartAutomationMethod() {
        //Set up Chrome options
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--incognito");
//        options.addArguments(
//                "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
        //initialize the WebDriver with the ChromeOptions
        driver = new ChromeDriver(options);

        //accesam o pagina web
        driver.get("https://www.barnesandnoble.com/");

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        //declaram un element
//        WebElement cookiePreferencesButton = driver.findElement(By.id("onetrust-pc-btn-handler"));
//        cookiePreferencesButton.click();
//
//        WebElement rejectCookiesButton = driver.findElement(By.id("onetrust-reject-all-handler"));
//        rejectCookiesButton.click();

        WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();

        //facem scroll up
        js.executeScript("window.scrollBy(0,-400)");

        WebElement continuatiCumparaturileButton = driver.findElement(By.xpath("//button[@onclick='javascript:contShop();']"));
        continuatiCumparaturileButton.click();

        //facem hover pe sectiunea Women
        // Create an Actions object to perform the hover
        Actions actions = new Actions(driver);
        WebElement womenSection = driver.findElement(By.id("fob-Women"));
        actions.moveToElement(womenSection).perform();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(womenSection));
//        womenSection.getText();

        //asteptam ca linkul pe care vrem sa dam click sa fie vizibil
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        WebElement cashmereLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-tracking*=cashmere]")));

        //dam click pe link-ul Cashmere
//        WebElement cashmereLink = driver.findElement(By.cssSelector("[data-tracking*=cashmere]"));
        cashmereLink.click();

//        //search for a specific item
//        WebElement searchField = driver.findElement(By.cssSelector("input[placeholder='Search']"));
//        String searchValue = "calvin klein red dress";
//        searchField.sendKeys(searchValue);

    }
}
