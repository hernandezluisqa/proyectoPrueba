package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarroDeCompraPage;
import pages.DatosDespachoPage;
import pages.EquiposPage;
import pages.HomePage;
import pages.IdentificacionPage;
import pages.TelefonoPage;
import utilities.BaseTest;
import utilities.OtherUtilities;
import static utilities.OtherUtilities.sleep;

public class ProductosTests extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final EquiposPage equiposPage = new EquiposPage();
    private final TelefonoPage telefonoPage = new TelefonoPage();

    private final IdentificacionPage identificacionPage = new IdentificacionPage();
    private final DatosDespachoPage datosDespachoPage = new DatosDespachoPage();

    private final CarroDeCompraPage carroDeCompraPage = new CarroDeCompraPage();

    @BeforeMethod
    public void setUp() {
        final var url = "https://www.entel.cl/";
        driver.get(url);
        homePage.clickEquiposButton();
    }

    @Test (groups = {smoke})
    public void buscarEquipoPorSKU() {
        equiposPage.buscarPorSku(0);
        equiposPage.abrirEquipoBuscado();
        telefonoPage.verifyPage();
        telefonoPage.verifyPhone(0);
    }

    @Test (groups = {smoke})
    public void comprarProducto() {
        equiposPage.buscarPorSku(1);
        equiposPage.abrirEquipoBuscado();
        telefonoPage.verifyPage();
        telefonoPage.verifyPhone(1);
        telefonoPage.comprarEquipoPrecioGeneral();
        identificacionPage.waitPageToLoad();
        identificacionPage.verifyPage();
        identificacionPage.llenarFormularioDatosValidos();
        OtherUtilities.sleep(5000);
        carroDeCompraPage.waitPageToLoad();
        carroDeCompraPage.clickContinuarButton();
        datosDespachoPage.waitPageToLoad();
        datosDespachoPage.llenarDatosDespacho();
        datosDespachoPage.validarTituloCarrito();
    }

}
