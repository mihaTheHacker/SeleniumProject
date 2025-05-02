package HelperMethods;

import org.openqa.selenium.WebDriver;

public class FramesMethods {
    WebDriver driver;

    public FramesMethods(WebDriver driver) {
        this.driver = driver;
    }
    public void switchToMainContent(){
        driver.switchTo().defaultContent();
    }

}
