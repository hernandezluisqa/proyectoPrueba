package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.BasePage;
import utilities.BaseTest;

public class BarPages extends BasePage {

    private final By barContainer = By.className("primary_header");
    private final By buggerButton = By.id("react-burger-menu-btn");
    private final By barTitle = By.className("app_logo");

    @Override
    public void waitPageToLoad() {
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(barContainer).isDisplayed());
        softAssert.assertTrue(find(buggerButton).isDisplayed());
        softAssert.assertTrue(find(barTitle).isDisplayed());
        softAssert.assertAll();
    }

    public void openBurgerMenu(){
        find(buggerButton).click();
    }
}
