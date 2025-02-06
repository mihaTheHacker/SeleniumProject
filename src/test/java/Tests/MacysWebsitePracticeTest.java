package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class MacysWebsitePracticeTest {

    public WebDriver driver;



    @Test
    public void macysAddToCartAutomationMethod() {


        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://www.macys.com/");

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        //declaram un element
//        WebElement cookiePreferencesButton = driver.findElement(By.id("onetrust-pc-btn-handler"));
//        cookiePreferencesButton.click();
//
        WebElement rejectCookiesButton = driver.findElement(By.id("onetrust-reject-all-handler"));
        rejectCookiesButton.click();

//        WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
//        acceptCookiesButton.click();

        //facem scroll up
        js.executeScript("window.scrollBy(0,-400)");

        WebElement continuatiCumparaturileButton = driver.findElement(By.xpath("//button[@onclick='javascript:contShop();']"));
        continuatiCumparaturileButton.click();

        //dam click pe sectiunea Women
        WebElement womenSection = driver.findElement(By.id("fob-Women"));
        womenSection.click();


    }
}
