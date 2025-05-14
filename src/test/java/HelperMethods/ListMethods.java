package HelperMethods;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ListMethods {

    WebDriver driver;

    public ListMethods(WebDriver driver) {
        this.driver = driver;

    }

    @Test

    public void changeListOrderByDragAndDrop() {
        Actions actions = new Actions(driver);
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));
        for (int i = 0; i < list.size() - 1; i++) {
            WebElement currentWebElement = list.get(i);
            WebElement urmatorulWebElement = list.get(i + 1);
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
