package utilities;

import com.github.javafaker.Faker;
import listeners.SuiteListeners;
import listeners.TestListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Listeners({TestListeners.class, SuiteListeners.class})
public class BaseTest {
    protected SoftAssert softAssert;
    protected Faker faker;
    protected final String smoke = "smoke";
    protected final String regression = "regression";
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void masterSetUp() {
        softAssert = new SoftAssert();
        Logs.debug("Inicializando el Driver");

        // Inicializar el driver
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        Logs.debug("Borrando Cookies");
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        Logs.debug("Asignando driver al webdriver provider");
        new WebDriverProvider().set(driver);

        faker = new Faker();
    }

    @AfterMethod(alwaysRun = true)
    public void masterTearDown() {
        Logs.info("Matando el padre");
        driver.quit();
    }

    protected void sleep(int timeMs){
        try{
            Thread.sleep(timeMs);
        } catch (InterruptedException interruptedException){
            Logs.error("InterruptedException: %s", interruptedException.getLocalizedMessage());
        }
    }  //Es mejor usar un sleep mas dinamico, espera implicitas.
}
