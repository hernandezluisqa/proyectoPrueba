package pages;

import modelos.Telefono;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;
import utilities.TelefonosAccesorios;

import java.time.Duration;

public class EquiposPage extends BasePage {

    private final By searchInput = By.cssSelector("#searchBody > .form-group > #searchInputBox");
    private final By producto = By.cssSelector(".search-results > .list-unstyled > li > a");

    @Override
    public void waitPageToLoad() {
        waitPage(searchInput, getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {

    }

    public Telefono seleccionarTelefono(int position){
        return TelefonosAccesorios.obtenerTelefono(position);
    }

    public void buscarPorSku(int jsonPosition){
        final Telefono telefono = TelefonosAccesorios.obtenerTelefono(jsonPosition);

        final var telefonoSku = telefono.getSku();

        final var searchElement = find(searchInput);
        new Actions(getDriver())
                .moveToElement(searchElement)
                .click()
                .sendKeys(telefonoSku)
                .perform();
    }

    public void abrirEquipoBuscado(){
        waitPage(producto, getClass().getSimpleName());
        find(producto).click();
    }
}
