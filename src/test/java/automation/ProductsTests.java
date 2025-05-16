package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.ShoppingPage;
import utilities.BaseTest;

public class ProductsTests extends BaseTest {
    final LoginPage loginPage = new LoginPage();
    final ShoppingPage shoppingPage = new ShoppingPage();
    final ProductPage productPage = new ProductPage();

    @BeforeMethod
    public void setUp() {
        driver.get("https://www.saucedemo.com/");
        loginPage.waitPageToLoad(); //espero que cargue la pagina

        loginPage.fillLogin("standard_user", "secret_sauce");
        shoppingPage.waitPageToLoad(); //espero que cargue la pagina

        shoppingPage.goToItemDetail("Sauce Labs Fleece Jacket");
        productPage.waitPageToLoad();
    }

    @Test (groups = {})
    public void productDetailTest() {
        productPage.verifyPage();
    }

    @Test (groups = {smoke})
    public void backToProductsTest() {
        productPage.clickBackToProducts();
        shoppingPage.waitPageToLoad();
        shoppingPage.verifyPage();
    }
}
