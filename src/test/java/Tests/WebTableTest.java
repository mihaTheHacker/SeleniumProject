package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptMethods;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.WebTablePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import SharedData.SharedData;
import org.testng.annotations.Test;

public class WebTableTest extends SharedData {

    JavascriptMethods javascriptMethods;
    ElementsMethods elementsMethods;
    HomePage homePage;
    CommonPage commonPage;
    WebTablePage webTablePage;

    @Test
    public void automationMethod() {

        javascriptMethods = new JavascriptMethods(driver);
        elementsMethods = new ElementsMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        webTablePage = new WebTablePage(driver);

        homePage.goToDesiredMenu("Elements");

        commonPage.goToDesiredSubMenu("Web Tables");

        List<WebElement> tableElements = driver.findElements(
                By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer actualTableSize = tableElements.size();

        String firstNameValue = "Miha";
        String lastNameValue = "Pop";
        String emailValue = "test@test.com";
        String ageValue = "30";
        String salaryValue = "1000";
        String departmentValue = "QA";
        webTablePage.completeRegistrationForm(firstNameValue, lastNameValue, emailValue, ageValue, salaryValue, departmentValue);

        List<WebElement> expectedTableElements = driver.findElements(
                By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));

        Integer expectedTableSize = actualTableSize + 1;
        Assert.assertEquals(expectedTableElements.size(), expectedTableSize);

        String actualTableValue = expectedTableElements.get(3).getText();
        Assert.assertTrue(actualTableValue.contains(firstNameValue));
        Assert.assertTrue(actualTableValue.contains(lastNameValue));
        Assert.assertTrue(actualTableValue.contains(emailValue));
        Assert.assertTrue(actualTableValue.contains(ageValue));
        Assert.assertTrue(actualTableValue.contains(ageValue));
        Assert.assertTrue(actualTableValue.contains(salaryValue));
        Assert.assertTrue(actualTableValue.contains(departmentValue));

        driver.quit();

    }

}