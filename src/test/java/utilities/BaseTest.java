package utilities;

import com.github.javafaker.Faker;
import listeners.SuiteListeners;
import listeners.TestListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners({TestListeners.class, SuiteListeners.class})
public class BaseTest {
    protected Faker faker;
    protected final String smoke = "smoke";
    protected final String regression = "regression";
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void masterSetUp() {
        Logs.debug("Inicializando el Driver");

        // Inicializar el driver
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        Logs.debug("Borrando Cookies");
        driver.manage().deleteAllCookies();

        Logs.debug("Asignando driver al webdriver provider");
        new WebDriverProvider().set(driver);

        faker = new Faker();
    }

    @AfterMethod(alwaysRun = true)
    public void masterTearDown() {
        Logs.info("Matando el padre");
        driver.quit();
    }
}
