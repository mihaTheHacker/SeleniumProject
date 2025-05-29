package Pages;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import HelperMethods.JavascriptMethods;
import HelperMethods.ListMethods;
import HelperMethods.WindowsMethods;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {

    protected WebDriver driver;
    protected ElementsMethods elementsMethods;
    protected JavascriptMethods javascriptMethods;
    protected AlertMethods alertMethods;
    protected WindowsMethods windowsMethods;
    protected FramesMethods framesMethods;
    protected ListMethods listMethods;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptMethods = new JavascriptMethods(driver);
        this.alertMethods = new AlertMethods(driver);
        this.windowsMethods = new WindowsMethods(driver);
        this.framesMethods = new FramesMethods(driver);
        this.listMethods = new ListMethods(driver);
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

