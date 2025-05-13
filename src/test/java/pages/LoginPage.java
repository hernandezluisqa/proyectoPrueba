package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.BasePage;
import utilities.Logs;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test=\"error\"]");


    @Override
    @Step("Esperando cargue la pagina") //Para reporte en allure
    public void waitPageToLoad() {
        waitPage(usernameInput, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verificando la pagina de login")
    public void verifyPage() {
        Logs.info("Verificando la pagina de login");
        softAssert.assertTrue(find(usernameInput).isDisplayed());
        softAssert.assertTrue(find(passwordInput).isDisplayed());
        softAssert.assertTrue(find(loginButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Rellenando el formulario de Login")
    public void fillLogin(String username, String password){
        Logs.info("Escribiendo el username");
        find(usernameInput).sendKeys(username);
        Logs.info("Escribiendo el password");
        find(passwordInput).sendKeys(password);
        Logs.info("Haciendo click en boton login");
        find(loginButton).click();
    }

    @Step("Verificando mensaje de error")
    public void verifyErrorMessage(String expectedText){
        final var errorLabel = find(errorMessage);
        softAssert.assertTrue(errorLabel.isDisplayed());
        softAssert.assertEquals(errorLabel.getText(), expectedText);
        softAssert.assertAll();
    }
}
