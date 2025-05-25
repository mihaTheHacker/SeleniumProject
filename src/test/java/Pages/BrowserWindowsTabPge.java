package Pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWindowsTabPge extends CommonPage{

    public BrowserWindowsTabPge(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tabButton")
    private WebElement tabButton;
    @FindBy(id = "sampleHeading")
    private WebElement sampleHeading;
    @FindBy(id = "windowButton")
    private WebElement windowButton;

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
