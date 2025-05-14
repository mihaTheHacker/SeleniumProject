package Tests;

import HelperMethods.ListMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Recursivitate {

    WebDriver driver;
    ListMethods listMethods;


    @Test
    public void parcurgereLista() {

        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        listMethods = new ListMethods(driver);

        //accesam o pagina web
        driver.get("https://demoqa.com/sortable");

        //facem browserul in modul maximize
        driver.manage().window().maximize();
        listMethods.changeListOrderByDragAndDrop();

       //inchidem browserul
        driver.quit();
    }

}
