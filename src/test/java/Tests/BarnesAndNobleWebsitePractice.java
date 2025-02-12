package Tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BarnesAndNobleWebsitePractice {

    @Test
    public void barnesAndNobleAddToCartAutomationMethod() {

        //Set up Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        //deschidem un browser de Chrome
        ChromeDriver driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://www.barnesandnoble.com/");

        // facem browserul in modul maximize
        driver.manage().window().maximize();

        //dam click pe butonul de acceptare a cookies

        WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        assert acceptCookiesButton.isDisplayed();
        acceptCookiesButton.click();

        //verificam daca lista de sectiuni din navigation bar este afisata
        List<String> expectedNavigationBarSections = List.of("Books", "Fiction", "Nonfiction", "eBooks", "Audiobooks", "Teens & YA", "Teens", "Kids", "Toys & Games", "Stationery & Gifts", "Music & Movies");
        List<String> actualNavigationBarSections = new ArrayList<>();
        List<WebElement> navigationBarSections = driver.findElements(By.cssSelector(".booksNav > li"));
        for (int i = 0; i < navigationBarSections.size(); i++) {
            actualNavigationBarSections.add(navigationBarSections.get(i).getText());
            System.out.println(navigationBarSections.get(i).getText());
        }

        assert actualNavigationBarSections.equals(expectedNavigationBarSections);

    }
}
