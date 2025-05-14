package Pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {

    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptMethods javascriptMethods;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptMethods = new JavascriptMethods(driver);
        PageFactory.initElements(driver, this);
    }

    //Identificam elementele specifice pentru sub-pagini
    @FindBy(xpath = "//span[@class='text']")
    List<WebElement> elements;

    //Facem metode specifice pentru pagina
    public void goToDesiredSubMenu(String submenu) {
        javascriptMethods.jsScrollDown(0, 400);
        elementsMethods.selectElementFromListByText(elements, submenu);
    }

}

