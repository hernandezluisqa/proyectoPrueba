package pages;

import org.openqa.selenium.By;
import utilities.BasePage;

public class CarroDeCompraPage extends BasePage {

    private final By title = By.className("title-con");
    private final By brand = By.cssSelector(".detail-info > .p-title");



    @Override
    public void waitPageToLoad() {

    }

    @Override
    public void verifyPage() {

    }
}
