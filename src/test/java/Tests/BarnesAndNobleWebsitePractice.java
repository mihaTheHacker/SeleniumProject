package Tests;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
        List<String> expectedNavigationBarSections = List.of("Books", "Fiction", "Nonfiction", "eBooks", "Audiobooks", "Teens & YA", "Kids",
                "Toys & Games", "Stationery & Gifts", "Music & Movies");
        List<String> actualNavigationBarSections = new ArrayList<>();
        List<WebElement> navigationBarSections = driver.findElements(By.cssSelector(".booksNav > li"));
        for (int i = 0; i < navigationBarSections.size(); i++) {
            actualNavigationBarSections.add(navigationBarSections.get(i).getText());
            System.out.println(navigationBarSections.get(i).getText());
        }

        assert actualNavigationBarSections.equals(expectedNavigationBarSections);

        //dam hover pe sectiunea de Books
        Actions actions = new Actions(driver);
        WebElement booksSection = driver.findElement(By.id("rhfCategoryFlyout_Books"));
        actions.moveToElement(booksSection).perform();

        //dam click pe sectiunea B&N Monthly Picks
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        WebElement bnMonthlyPicksSection = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[aria-labelledby='rhfCategoryFlyout_Books'] .dropdown-item[href*='barnes-noble-monthly-picks']")));
        bnMonthlyPicksSection.click();

        //verificam daca suntem pe pagina B&N Monthly Picks
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Our Monthly Picks | Barnes & Noble®";
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "The page title is not as expected");


    }

}
