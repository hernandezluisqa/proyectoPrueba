package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseTest;
import utilities.Logs;

public class NavegationTest extends BaseTest {
    @Test(groups = {regression, smoke})
    public void ejercicio1Test() {
        final var url = "https://www.saucedemo.com/";

        Logs.info("Navegamos a la web %s", url);
        driver.get(url);

        Logs.info("Obtenermos la URL");
        final var currentUrl = driver.getCurrentUrl();

        Logs.info("Verificando que las URL sean iguales");

        Assert.assertEquals(currentUrl, url);
    }

    @Test(groups = {regression})
    public void ejercicio2Test() {
        final var url1 = "https://the-internet.herokuapp.com/";
        final var url2 = "https://github.com/";

        Logs.info("Navegamos a la URL %s", url1);
        driver.get(url1);

        Logs.info("Navegamos a la URL %s", url2);
        driver.get(url2);

        Logs.info("Volvemos a la URL %s", url1);
        driver.navigate().back();

        Logs.info("Obtenemos la URL actual");
        final var currentUrl = driver.getCurrentUrl();

        Logs.info("Verificamos que la URL actual sea la misma que la esperada (%s)", url1);
        Assert.assertEquals(currentUrl, url1);
    }

    @Test(groups = {regression})
    public void failToScreenshotTest() {
        final var url = "https://the-internet.herokuapp.com/";
        final var url2 = "https://the-internet.herokuapp.com/";

        Logs.info("Navegando a la url %s", url);
        driver.get(url);

        Logs.info("Obtenemos la URL actual");
        final var actualUrl = driver.getCurrentUrl();

        Logs.info("Verificando las url");
        Assert.assertEquals(actualUrl, "url");
    }

    @Test
    public void sleepTest() {
        final var url = "https://www.saucedemo.com/";

        Logs.info("Ingresamos a la URL %s", url);
        driver.get(url);

        Logs.info("Esperamos 2.5 segundos");
        sleep(2500);

        Logs.info("Obtenemos la url actual");
        final var currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, url);
    }

    @Test
    public void webElements1() {
        final var url = "https://www.saucedemo.com/";
        final var lockedUsername = "locked_out_user";
        final var password = "secret_sauce";
        final var loginButonID = "login-button";
        final var errorMessage = "Epic sadface: Sorry, this user has been locked out.";

        Logs.info("Ingresamos a la URL %s", url);
        driver.get(url);

        Logs.info("Esperamos 2.5 segundos");
        sleep(3000);

        Logs.info("Obtenemos los web elementes");

        final var usernameInput = By.id("user-name");
        final var passwordInput = By.id("password");

        Logs.info("Escribimos usuario y password en inputs");
        driver.findElement(usernameInput).sendKeys(lockedUsername);
        driver.findElement(passwordInput).sendKeys(password);

        Logs.info("Hacemos click en el boton login");
        driver.findElement(By.id(loginButonID)).click();

        Logs.info("Esperamos 2 segundos");
        sleep(2000);

        Logs.info("Verificamos Mensaje de Error");
        final var currentErrorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));

        softAssert.assertTrue(currentErrorMessage.isDisplayed());
        softAssert.assertEquals(currentErrorMessage.getText(), errorMessage);
        softAssert.assertAll();

    }

    @Test
    public void webElements2Test() {
        final var url = "https://www.saucedemo.com/";
        final var mainUrl = "https://www.saucedemo.com/inventory.html";
        final var validUsername = "standard_user";
        final var validPassword = "secret_sauce";

        Logs.info("Ingresamos a la URL %s", url);
        driver.get(url);

        Logs.info("Esperamos 3 segundos");
        sleep(3000);

        Logs.info("Escribimos usuario y password en inputs");
        driver.findElement(By.id("user-name")).sendKeys(validUsername);
        driver.findElement(By.id("password")).sendKeys(validPassword);

        Logs.info("Hacemos click en el boton login");
        driver.findElement(By.id("login-button")).click();

        Logs.info("Esperamos 2 segundos");
        sleep(2000);

        Logs.info("Obtenemos la URL actual");
        final var currentUrl = driver.getCurrentUrl();
        final var inventoryList = driver.findElement(By.className("inventory_list"));

        Logs.info("Verificamos URL");
        Assert.assertEquals(currentUrl, mainUrl);
        Assert.assertTrue(inventoryList.isDisplayed());

        Logs.info("Esperamos 1 segundo");
        sleep(1000);

    }

    @Test
    public void webElements3Test() {
        final var url = "https://www.saucedemo.com/";
        final var mainUrl = "https://www.saucedemo.com/inventory.html";
        final var validUsername = "standard_user";
        final var validPassword = "secret_sauce";

        Logs.info("Ingresamos a la URL %s", url);
        driver.get(url);

        Logs.info("Esperamos 3 segundos");
        sleep(3000);

        Logs.info("Escribimos usuario y password en inputs");
        driver.findElement(By.id("user-name")).sendKeys(validUsername);
        driver.findElement(By.id("password")).sendKeys(validPassword);

        Logs.info("Hacemos click en el botón login");
        driver.findElement(By.id("login-button")).click();

        Logs.info("Esperamos 2 segundos");
        sleep(1000);

        Logs.info("Obtenemos la URL actual");
        final var currentUrl = driver.getCurrentUrl();
        softAssert.assertEquals(currentUrl, mainUrl, "La URL luego del login no es la esperada");

        Logs.info("Verificamos que el inventario esté presente");
        final var inventoryList = driver.findElement(By.className("inventory_list"));
        softAssert.assertTrue(inventoryList.isDisplayed(), "El inventario no está visible");

        Logs.info("Esperamos 1 segundo");
        sleep(1000);

        final var imageList = driver.findElements(By.cssSelector("img.inventory_item_img"));
        softAssert.assertFalse(imageList.isEmpty(), "No se encontraron imágenes de productos");

        Logs.info("Hacemos click en el primer elemento de la lista");
        imageList.get(1).click();

        Logs.info("Esperamos 3 segundos");
        sleep(1000);

        Logs.info("Verificando detalle del producto");
        softAssert.assertTrue(driver.findElement(By.cssSelector(".inventory_details_name.large_size")).isDisplayed(), "Nombre del producto no visible");
        softAssert.assertTrue(driver.findElement(By.cssSelector(".inventory_details_desc.large_size")).isDisplayed(), "Descripción del producto no visible");
        softAssert.assertTrue(driver.findElement(By.className("inventory_details_price")).isDisplayed(), "Precio del producto no visible");
        softAssert.assertTrue(driver.findElement(By.xpath("//button[text()='Add to cart']")).isDisplayed(), "Botón 'Add to cart' no visible");
        softAssert.assertTrue(driver.findElement(By.className("inventory_details_img")).isDisplayed(), "Imagen del producto no visible");

        softAssert.assertAll();
    }

    @Test
    public void selectTest() {
        final var url = "https://www.saucedemo.com/";
        final var mainUrl = "https://www.saucedemo.com/inventory.html";
        final var validUsername = "standard_user";
        final var validPassword = "secret_sauce";
        final var expectedFirstElement = "Test.allTheThings() T-Shirt (Red)";
        final var expectedLastElement = "Sauce Labs Backpack";

        Logs.info("Ingresamos a la URL %s", url);
        driver.get(url);

        Logs.info("Esperamos 3 segundos");
        sleep(3000);

        Logs.info("Escribimos usuario y password en inputs");
        driver.findElement(By.id("user-name")).sendKeys(validUsername);
        driver.findElement(By.id("password")).sendKeys(validPassword);

        Logs.info("Hacemos click en el botón login");
        driver.findElement(By.id("login-button")).click();

        Logs.info("Esperamos 2 segundos");
        sleep(1000);

        Logs.info("Obtenemos la URL actual");
        final var currentUrl = driver.getCurrentUrl();
        softAssert.assertEquals(currentUrl, mainUrl, "La URL luego del login no es la esperada");

        final var selectElement = driver.findElement(By.className("product_sort_container"));
        final var select = new Select(selectElement);

        select.selectByValue("za");

        final var productListName = driver.findElements(By.className("inventory_item_name"));
        final var firstElement = productListName.get(0);
        final var lastElemet = productListName.get(productListName.size()-1);

        softAssert.assertEquals(firstElement.getText(), expectedFirstElement);
        softAssert.assertEquals(lastElemet.getText(), expectedLastElement);
        softAssert.assertAll();
    }

    @Test
    public void hipervinculoTest() {
        final var url = "https://www.saucedemo.com/";
        final var mainUrl = "https://www.saucedemo.com/inventory.html";
        final var validUsername = "standard_user";
        final var validPassword = "secret_sauce";
        final var expectedFirstElement = "Test.allTheThings() T-Shirt (Red)";
        final var expectedLastElement = "Sauce Labs Backpack";

        Logs.info("Ingresamos a la URL %s", url);
        driver.get(url);

        Logs.info("Esperamos 3 segundos");
        sleep(3000);

        Logs.info("Escribimos usuario y password en inputs");
        driver.findElement(By.id("user-name")).sendKeys(validUsername);
        driver.findElement(By.id("password")).sendKeys(validPassword);

        Logs.info("Hacemos click en el botón login");
        driver.findElement(By.id("login-button")).click();

        Logs.info("Esperamos 2 segundos");
        sleep(1000);

        Logs.info("Obtenemos la URL actual");
        final var currentUrl = driver.getCurrentUrl();
        softAssert.assertEquals(currentUrl, mainUrl, "La URL luego del login no es la esperada");

        final var socialFacebook = driver.findElement(By.cssSelector("a[data-test='social-facebook']"));
        final var hrefFacebook = socialFacebook.getAttribute("href");
        final var expectedHrefFacebook = "https://www.facebook.com/saucelabs";

        softAssert.assertTrue(socialFacebook.isDisplayed());
        softAssert.assertTrue(socialFacebook.isEnabled());
        softAssert.assertEquals(hrefFacebook, expectedHrefFacebook);
        softAssert.assertAll();
    }
}
