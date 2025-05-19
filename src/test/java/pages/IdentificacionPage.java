package pages;

import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.DatosC;

public class IdentificacionPage extends BasePage {

    private final By rut = By.id("identificationNumber");
    private final By phoneNumber = By.id("phoneNumber");
    private final By email = By.id("email");
    private final By indentificacionButton = By.cssSelector(".btn-con > .default-button");



    @Override
    public void waitPageToLoad() {
        waitPage(indentificacionButton, getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(rut).isDisplayed());
        softAssert.assertTrue(find(phoneNumber).isDisplayed());
        softAssert.assertTrue(find(email).isDisplayed());
        softAssert.assertAll();
    }

    public void llenarFormularioDatosValidos(){
        find(rut).sendKeys(DatosC.datosCliente().getRut());
        find(phoneNumber).sendKeys(DatosC.datosCliente().getTelefono());
        find(email).sendKeys(DatosC.datosCliente().getEmail());
        find(indentificacionButton).click();
    }
}
