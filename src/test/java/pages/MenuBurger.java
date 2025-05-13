package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;
import utilities.Logs;

import java.time.Duration;

public class MenuBurger extends BasePage{
    private final By menuBurgger = By.className("bm-menu-wrap");
    private final By logoutButon = By.id("logout_sidebar_link");
    private final By aboutButton = By.id("about_sidebar_link");

    @Override
    @Step("Esperanmdo que cargue la pagina")
    public void waitPageToLoad() {
        waitPage(logoutButon, this.getClass().getSimpleName());
        Logs.info("Esperando que el boton sea clickeable por la animacion");
        final WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButon));
    }

    @Override
    @Step("Verificando que cargue la pagina")
    public void verifyPage() {
        softAssert.assertTrue(find(logoutButon).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Haciendo click en boton logout")
    public void clickLogout(){
        find(logoutButon).click();
    }

    @Step("Verificando About Button")
    public void verifyAboutButton(String expectedUrl) {

        softAssert.assertTrue(find(aboutButton).isDisplayed());
        softAssert.assertTrue(find(aboutButton).isEnabled());
        softAssert.assertEquals(find(aboutButton).getAttribute("href"), expectedUrl);
        softAssert.assertAll();
    }
}
