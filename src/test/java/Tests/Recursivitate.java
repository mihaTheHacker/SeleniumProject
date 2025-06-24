package Tests;

import HelperMethods.ListMethods;
import Pages.CommonPage;
import Pages.HomePage;
import SharedData.Hooks;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
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
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Interactions menu");
        commonPage.goToDesiredSubMenu("Sortable");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user enters on Sortable sub-menu");
        listMethods.changeListOrderByDragAndDrop();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, "The user changes the order of the list by drag and drop");

    }

}
