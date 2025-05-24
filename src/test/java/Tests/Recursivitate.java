package Tests;

import HelperMethods.JavascriptMethods;
import HelperMethods.ListMethods;
import Pages.CommonPage;
import Pages.HomePage;
import SharedData.SharedData;
import org.testng.annotations.Test;

public class Recursivitate extends SharedData {

    ListMethods listMethods;
    JavascriptMethods javascriptMethods;
    HomePage homePage;
    CommonPage commonPage;


    @Test
    public void parcurgereLista() {

        listMethods = new ListMethods(driver);
        javascriptMethods = new JavascriptMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

        homePage.goToDesiredMenu("Interactions");
        commonPage.goToDesiredSubMenu("Sortable");
        listMethods.changeListOrderByDragAndDrop();

       //inchidem browserul
        driver.quit();
    }

}
