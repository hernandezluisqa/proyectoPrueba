package pages;

import modelos.Telefono;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.TelefonosAccesorios;

public class TelefonoPage extends BasePage {

    private final By productBrand = By.cssSelector(".equipment-introduce .equipment-brand");
    private final By productDescription = By.cssSelector(".equipment-introduce .equipment-title");
    private final By productSku = By.cssSelector(".equipment-introduce h4");
    private final By comprarEquipo = By.xpath("//*[contains(@class, 'buy-selection__menu--button')]/h6[text()='Equipo']");
    private final By comprarEquipoPlan = By.xpath("//*[contains(@class, 'buy-selection__menu--button')]/h6[text()='Equipo + Plan']");
    private final By precioOfertaLabel = By.cssSelector("label[for=\"equipment-renovation-price\"]");
    private final By precioGeneralLabel = By.cssSelector("label[for=\"equipment-free-price\"]");
    private final By loquieroButton = By.className("button-equipmentPrice");

    @Override
    public void waitPageToLoad() {
        waitPage(productBrand, getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(productBrand).isDisplayed());
        softAssert.assertTrue(find(productDescription).isDisplayed());
        softAssert.assertTrue(find(productSku).isDisplayed());
        softAssert.assertAll();
    }

    public void verifyPhone(int jsonPosition){
        final var phone = TelefonosAccesorios.obtenerTelefono(jsonPosition);
        softAssert.assertEquals(phone.getSku(), find(productSku).getText().replace("SKU: ", ""));
        softAssert.assertEquals(phone.getName(), find(productBrand).getText());
        softAssert.assertEquals(String.format(phone.getDescripcion()), find(productDescription).getText());
        softAssert.assertAll();
    }

    //Comprar telefono Equipo - precio general
    public void comprarEquipoPrecioGeneral (){
        find(comprarEquipo).click();
        find(precioGeneralLabel).click();
        find(loquieroButton).click();
    }
}
