package HelperMethods;

import java.io.File;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsMethods {

    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

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
    public void selectElementFromListByText(List<WebElement> elementList, String value){
        for(int i = 0; i < elementList.size();i++){
            if(elementList.get(i).getText().equals(value)){
                clickElement(elementList.get(i));
                break;
            }

    }
}}
