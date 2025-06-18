package Tests;

import HelperMethods.ListMethods;
import Pages.CommonPage;
import Pages.HomePage;
import SharedData.Hooks;
import org.testng.annotations.Test;

public class Recursivitate extends Hooks {

    ListMethods listMethods;
    HomePage homePage;
    CommonPage commonPage;


    @Test
    public void parcurgereLista() {

        listMethods = new ListMethods(getDriver());
        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());

        homePage.goToDesiredMenu("Interactions");
        commonPage.goToDesiredSubMenu("Sortable");
        listMethods.changeListOrderByDragAndDrop();

    }

}
