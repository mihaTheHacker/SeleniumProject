package Pages;

import java.util.List;
import logger.LoggerUtility;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage {

    // Identificam WebElementele specifice pentru pagina
    @FindBy(xpath = "//h5")
    private List<WebElement> elements;

    @FindBy(xpath = "//p[text()='Consent']")
    private WebElement consentElement;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Facem metode specifice pentru pagina
    public void goToDesiredMenu(String menu) {
        try {
            elementsMethods.clickElement(consentElement);
            LoggerUtility.infoLog("The user clicks on the consent element to accept cookies.");
        } catch (NoSuchElementException ignored) {
        }
        javascriptMethods.jsScrollDown(0, 400);
        LoggerUtility.infoLog("The user scrolls down the page.");

        elementsMethods.selectElementFromListByText(elements, menu);
        LoggerUtility.infoLog("The user selects from the menu the option with the value: " + menu + ".");
    }

}
