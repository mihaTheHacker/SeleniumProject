package Pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage {

    // Identificam WebElementele specifice pentru pagina
    @FindBy(xpath = "//h5")
    List<WebElement> elements;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Facem metode specifice pentru pagina
    public void goToDesiredMenu(String menu) {
        javascriptMethods.jsScrollDown(0, 400);
        elementsMethods.selectElementFromListByText(elements, menu);
    }

}
