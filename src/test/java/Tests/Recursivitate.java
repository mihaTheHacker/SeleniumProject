package Tests;

import HelperMethods.JavascriptMethods;
import HelperMethods.ListMethods;
import Pages.CommonPage;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Recursivitate {

    WebDriver driver;
    ListMethods listMethods;
    JavascriptMethods javascriptMethods;
    HomePage homePage;
    CommonPage commonPage;


    @Test
    public void parcurgereLista() {

        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        listMethods = new ListMethods(driver);
        javascriptMethods = new JavascriptMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

        driver.get("https://demoqa.com/");

        driver.manage().window().maximize();
        homePage.goToDesiredMenu("Interactions");
        commonPage.goToDesiredSubMenu("Sortable");
        listMethods.changeListOrderByDragAndDrop();

       //inchidem browserul
        driver.quit();
    }

}
