package automation;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import pages.HomePage;
import utilities.BaseTest;

public class EntelBarTests extends BaseTest {

    private final HomePage homePage = new HomePage();


    @BeforeMethod
    public void setUp() {
        final var url = "https://www.entel.cl/";
        driver.get(url);
    }

    @Test (groups = {smoke})
    public void openEquiposBarTest() {
        homePage.openEquiposMenu();
        homePage.clickEquiposButton();
    }
}
