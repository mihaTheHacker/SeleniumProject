package Pages;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import HelperMethods.WindowsMethods;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWindowsTabPge {

    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;
    AlertMethods alertMethods;
    WindowsMethods windowsMethods;

    public BrowserWindowsTabPge(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptMethods = new JavascriptMethods(driver);
        this.alertMethods = new AlertMethods(driver);
        this.windowsMethods = new WindowsMethods(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "tabButton")
    WebElement tabButton;
    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;
    @FindBy(id = "windowButton")
    WebElement windowButton;

    public void doNewTabTest() {
        elementsMethods.clickElement(tabButton);
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));
        System.out.println("Textul din new tab este:  " + sampleHeading.getText());
        windowsMethods.closeWindow();
        driver.switchTo().window(tabList.get(0));
    }
    public void doNewWindowTest() {
        elementsMethods.clickElement(windowButton);
        windowsMethods.switchToWindowByIndex(1);
        System.out.println("Textul din new window este:  " + sampleHeading.getText());
        windowsMethods.closeWindow();
        windowsMethods.switchToWindowByIndex(0);
    }
}
