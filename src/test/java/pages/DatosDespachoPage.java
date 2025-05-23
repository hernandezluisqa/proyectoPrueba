package pages;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.DatosC;
import utilities.Logs;
import utilities.OtherUtilities;

public class DatosDespachoPage extends BasePage {

    private By direccionLocator = By.id("google-address-autocomplete");
    private By dptOficCasaLocator = By.id("departmentValue");
    private By referenciaLocator = By.id("referenceValue");
    private By addressItemsLocator = By.cssSelector(".shipping-google-address__list-item div");
    private By continuarButtonLocator = By.className("button--primary");
    private By mensajePagarLocator = By.xpath("//*[@id=\"collapse-control-1\"]/div[1]/span");
    private By loaderLocator = By.id("loader");

    @Override
    public void waitPageToLoad() {
        waitPage(direccionLocator, getClass().getSimpleName());
        waitPage(dptOficCasaLocator, getClass().getSimpleName());
        waitPage(referenciaLocator, getClass().getSimpleName());
        waitPage(continuarButtonLocator, getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {

    }

    public void llenarDatosDespacho(){
        Logs.info("Completando formulario de datos del cliente");
        waitForLoaderToDisappear(loaderLocator);
        waitElementVisible(direccionLocator, "direccion");
        find(direccionLocator).sendKeys(DatosC.datosCliente().getDireccion().getCalleNumero());
        waitElementVisible(addressItemsLocator, "Lista de address");
        findAll(addressItemsLocator).get(0).click();
        waitElementVisible(referenciaLocator, "referencia");
        find(referenciaLocator).sendKeys(DatosC.datosCliente().getDireccion().getReferencia());
        waitElementVisible(dptOficCasaLocator, "Direccion Principal");
        find(dptOficCasaLocator).sendKeys(DatosC.datosCliente().getDireccion().getDpto());
        waitElementClickable(continuarButtonLocator, "boton");
        find(continuarButtonLocator).click();
    }

    public void validarTituloCarrito(){
        softAssert.assertTrue(find(mensajePagarLocator).isDisplayed());
        softAssert.assertEquals(find(mensajePagarLocator).getText(), "Pagas ahora");
        softAssert.assertAll();
    }

}
