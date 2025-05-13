package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class ShoppingPage extends BasePage {

    private final By title = By.className("title");
    private final By selectSortProducts = By.className("product_sort_container");
    private final By inventoryList = By.className("inventory_list");

    private By getItemName (String itemName){
        final var xpath = String.format("//div[text()='%s']", itemName);
        return By.xpath(xpath);
    }

    @Override
    @Step("Esperando cargue la pagina Shopping Page") //Para reporte en allure
    public void waitPageToLoad() {
        waitPage(inventoryList, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verificando la pagina de Shopping Page")
    public void verifyPage() {
        Logs.info("Verificando la pagina de Shopping Page");
        softAssert.assertTrue(find(title).isDisplayed());
        softAssert.assertTrue(find(selectSortProducts).isDisplayed());
        softAssert.assertTrue(find(inventoryList).isDisplayed());
        softAssert.assertAll();
    }

    public void goToItemDetail(String itemName) {
        find(getItemName(itemName)).click();
    }
}
