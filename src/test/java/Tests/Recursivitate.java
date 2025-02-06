package Tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Recursivitate {

    public WebDriver driver;
@Test
    public void parcurgereLista() {

        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/sortable");

        //facem browserul in modul maximize
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));
        for (int i = 0; i < list.size()-1; i++)
        {
            WebElement currentWebElement = list.get(i);
            WebElement urmatorulWebElement = list.get(i++);
            System.out.println("Numarul elementului este " + currentWebElement.getText());
            actions.clickAndHold(currentWebElement)
                    .moveToElement(urmatorulWebElement)
                    .release(currentWebElement)
                    .build()
                    .perform();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
