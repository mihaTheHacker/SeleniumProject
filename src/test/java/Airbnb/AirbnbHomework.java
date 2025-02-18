package Airbnb;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AirbnbHomework {

    @Test

    public void findAnAirbnb() {

        //1. Open the browser
        //deschidem un browser de Chrome
        ChromeDriver driver = new ChromeDriver();

        //2. Access the web page
        driver.get("https://www.airbnb.ie/");

        //3. Maximize the browser
        driver.manage().window().maximize();

        //4. Wait until the cookies popup is displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid=\"main-cookies-banner-container\"]")));

        //5. Click on Accept Cookies
        List<WebElement> cookiesButton = driver.findElements(By.cssSelector("[data-testid=\"main-cookies-banner-container\"] button"));
        for (WebElement button : cookiesButton) {
            if (button.getText().equals("Accept all")) {
                button.click();
                break;
            }
        }
        //6. Wait for the cookies popup to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[data-testid=\"main-cookies-banner-container\"]")));
        Assert.assertTrue(driver.findElements(By.cssSelector("[data-testid=\"main-cookies-banner-container\"]")).isEmpty());

        //7. Locate the categories description bar
        WebElement airbnbCategoriesCarousel = driver.findElement(By.cssSelector("[data-testid=\"content-scroller\"]"));

        //8. Get the list of categories
        List<WebElement> airbnbCategoriesButtons = airbnbCategoriesCarousel.findElements(
                By.cssSelector("#category-bar-description + div + div label"));
        Assert.assertEquals(airbnbCategoriesButtons.size(), 62, "The count does not match the expected value");

        //9. Print the list of categories
        for (WebElement category : airbnbCategoriesButtons) {
            System.out.println(category.getText());

            //10. Click on the Beachfront category
            if (category.getText().equals("Beachfront")) {
                category.click();
                break;
            }
        }
        //assert that the Beachfront category is selected
        Assert.assertTrue(driver.findElement(By.cssSelector("[data-testid=\"category-item--Beachfront--checked\"]")).isDisplayed());

    }

}
