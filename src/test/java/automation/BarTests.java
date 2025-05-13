package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BarPages;
import pages.LoginPage;
import pages.MenuBurger;
import pages.ShoppingPage;
import utilities.BaseTest;
import utilities.Logs;

public class BarTests extends BaseTest {
    final LoginPage loginPage = new LoginPage();
    final ShoppingPage shoppingPage = new ShoppingPage();
    final BarPages barPage = new BarPages();
    final MenuBurger menuBurger = new MenuBurger();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Logs.info("Navegando a la url");
        driver.get("https://www.saucedemo.com/");
        loginPage.waitPageToLoad(); //espero que cargue la pagina

        loginPage.fillLogin("standard_user", "secret_sauce");
        shoppingPage.waitPageToLoad(); //espero que cargue la pagina

        barPage.openBurgerMenu();

        menuBurger.waitPageToLoad();
    }

    @Test (groups = {regression})
    public void logoutTest() {
        menuBurger.clickLogout();
        loginPage.waitPageToLoad();
        loginPage.verifyPage();
    }

    @Test (groups = {regression, smoke})
    public void aboutButtomTest() {
        menuBurger.verifyAboutButton("https://saucelabs.com/");
    }
}
