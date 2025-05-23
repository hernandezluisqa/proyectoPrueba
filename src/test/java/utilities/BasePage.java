package utilities;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

@Listeners({TestListeners.class, SuiteListeners.class})
public abstract class BasePage {

    private final static int defaultTimeOut = 10;
    protected final SoftAssert softAssert;
    private final int timeOut;

    public BasePage(int timeOut) {
        softAssert = new SoftAssert();
        this.timeOut = timeOut;
    }

    public BasePage(){
        this(defaultTimeOut);
    }

    protected WebDriver getDriver() {
        return new WebDriverProvider().get();
    }

    protected void waitPage(By locator, String pageName) {
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(this.timeOut));

        Logs.info("Esperando que la pagina %s cargue", pageName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Logs.info("Ha cargado satisfactoriamente la pagina %s", pageName);
    }

    protected void waitElement(By locator, String elementName) {
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(this.timeOut));

        Logs.info("Esperando que el element %s cargue", elementName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Logs.info("Ha cargado satisfactoriamente el elemento %s", elementName);
    }

    protected void waitElementClickable(By locator, String elementName) {
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(this.timeOut));

        Logs.info("Esperando que el element %s cargue para ser clickeable", elementName);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        Logs.info("Ha cargado satisfactoriamente el elemento %s para ser clickeable", elementName);
    }

    protected void waitForLoaderToDisappear(By loaderLocator) {
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(this.timeOut));
        Logs.info("Esperando que desaparezca el loader...");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
        Logs.info("El loader ha desaparecido");
    }

    protected void waitElementVisible(By locator, String elementName) {
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(this.timeOut));

        Logs.info("Esperando que el elemento %s sea visible", elementName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Logs.info("El elemento %s es visible", elementName);
    }

    protected WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }

    public abstract void waitPageToLoad();

    public abstract void verifyPage();

}
