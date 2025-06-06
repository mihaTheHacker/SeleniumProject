package HelperMethods;

import java.io.File;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsMethods {

    WebDriver driver;
    JavascriptMethods javascriptMethods;
    Actions actions;

    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
        this.javascriptMethods = new JavascriptMethods(driver);
        this.actions = new Actions(driver);
    }


    public void clickElement(WebElement element) {
        element.click();

    }

    public void fillElement(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void uploadPicture(WebElement element) {
        File file = new File("src/test/resources/Pixar-Wall-E.webp");
        element.sendKeys(file.getAbsolutePath());
    }

    public void selectElementFromListByText(List<WebElement> elementList, String value) {
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().equals(value)) {
                clickElement(elementList.get(i));
                break;
            }

        }
    }

    public void fillWithActions(WebElement element, String value) {
        actions.sendKeys(value).perform();
        waitForElementToBeVisible(element);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void fillMultipleValues(WebElement element, List<String> list) {
        for (String value : list) {
            element.sendKeys(value);
//            element.sendKeys(Keys.ENTER);

        }

    }

    public void clickMultipleValues(List<WebElement> elements, List<String> list) {
        for (String value : list) {
            for (WebElement element : elements) {
                if (element.getText().equals(value)) {
                    element.click();
                    break;

                }
            }
        }


    }
}
