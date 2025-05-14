package HelperMethods;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class WindowsMethods {

    public WindowsMethods(WebDriver driver) {
        this .driver = driver;

    }

    WebDriver driver;

    public void closeWindow() {
        driver.close();
    }
    public void switchToWindowByIndex(int index){
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        if (index >= 0 && index < windowList.size()) {
            driver.switchTo().window(windowList.get(index));
        } else {
            System.out.println("Indexul nu este valid");
        }
        driver.close();
    }


}
