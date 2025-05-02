package HelperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptMethods {


    private final JavascriptExecutor js;

    public JavascriptMethods(WebDriver driver) {

        js = (JavascriptExecutor) driver;
    }

    public void sendKeys(String keys, WebElement element) {
        js.executeScript("arguments[0].click();", element);
        element.sendKeys(keys);
        element.sendKeys(Keys.ENTER);
    }

    public void jsClickElement(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }
    public void jsScrollDown() {
        js.executeScript("window.scrollBy(0, 400)");
    }
}


