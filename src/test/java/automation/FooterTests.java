package automation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FooterPage;
import pages.LoginPage;
import pages.ShoppingPage;
import utilities.BaseTest;
import utilities.Logs;

public class FooterTests extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final FooterPage footerPage = new FooterPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Logs.info("Navegando a la url");
        driver.get("https://www.saucedemo.com/");
        loginPage.waitPageToLoad(); //espero que cargue la pagina

        loginPage.fillLogin("standard_user", "secret_sauce");
        shoppingPage.waitPageToLoad(); //espero que cargue la pagina
        footerPage.verifyPage();
    }

    @Test (groups = {regression})
    public void verifyingSocialMediaLinksTest() {
        final var twiterUrl = "https://twitter.com/saucelabs";
        final var facebookUrl = "https://www.facebook.com/saucelabs";
        final var linkedinUrl = "https://www.linkedin.com/company/sauce-labs/";

        footerPage.verifySocialMediaLinks(twiterUrl, facebookUrl, linkedinUrl);
    }
}
