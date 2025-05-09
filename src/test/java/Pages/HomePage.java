package Pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptMethods = new JavascriptMethods(driver);
        PageFactory.initElements(driver, this);
    }
// Identificam WebElementele specifice pentru pagina
    @FindBy(xpath = "//h5")
    List<WebElement> elements;

    //Facem metode specifice pentru pagina
    public void goToDesiredMenu(String menu){
        javascriptMethods.jsScrollDown(0, 400);
        elementsMethods.selectElementFromListByText(elements, menu );
    }



}
