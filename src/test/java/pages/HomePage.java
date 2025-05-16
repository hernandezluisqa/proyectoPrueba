package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.BasePage;

public class HomePage extends BasePage {
    final By headerShadowRoot = By.cssSelector("andino-header");
    //Header Locators from ShadowRoot
    final By headerMenu = By.cssSelector(".eds-header__menu-desk__nav");
    final By equiposMenu = By.cssSelector("#list-item-3");


    @Step("Waiting loading page.")
    @Override
    public void waitPageToLoad() {
        waitPage(headerShadowRoot, getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
    }

    public void openEquiposMenu(){
        final var headerShadowRootElements = find(headerShadowRoot).getShadowRoot();
        final var headerMenuElement = headerShadowRootElements.findElement(headerMenu);
        final var equiposMenuElement = headerMenuElement.findElement(equiposMenu);
        new Actions(getDriver())
                .moveToElement(equiposMenuElement)
                .perform();
    }

    public void clickEquiposButton(){
        final var headerShadowRootElements = find(headerShadowRoot).getShadowRoot();
        final var headerMenuElement = headerShadowRootElements.findElement(headerMenu);
        final var equiposMenuElement = headerMenuElement.findElement(equiposMenu);

        equiposMenuElement.click();
    }
}
