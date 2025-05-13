package pages;

import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class FooterPage extends BasePage {
    private final By twiter = By.cssSelector("a[data-test=\"social-twitter\"]");
    private final By linkedin = By.cssSelector("a[data-test=\"social-linkedin\"]");
    private final By facebook = By.cssSelector("a[data-test=\"social-facebook\"]");
    private final By footerTextContainer = By.className("footer_copy");

    @Override
    public void waitPageToLoad() {
        waitPage(twiter, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(twiter).isDisplayed());
        softAssert.assertTrue(find(facebook).isDisplayed());
        softAssert.assertTrue(find(linkedin).isDisplayed());
        softAssert.assertTrue(find(footerTextContainer).isDisplayed());
        softAssert.assertAll();
    }

    public void verifySocialMediaLinks(String twitterUrl, String facebookUrl, String linkedinUrl){
        final var twitterElement = find(twiter);
        final var facebookElement = find(facebook);
        final var linkedinElement = find(linkedin);

        Logs.info("Verificando los links de las redes sociales");
        softAssert.assertTrue(twitterElement.isDisplayed());
        softAssert.assertTrue(twitterElement.isEnabled());
        softAssert.assertEquals(twitterElement.getAttribute("href"), twitterUrl);

        softAssert.assertTrue(facebookElement.isDisplayed());
        softAssert.assertTrue(facebookElement.isEnabled());
        softAssert.assertEquals(facebookElement.getAttribute("href"), facebookUrl);

        softAssert.assertTrue(linkedinElement.isDisplayed());
        softAssert.assertTrue(linkedinElement.isEnabled());
        softAssert.assertEquals(linkedinElement.getAttribute("href"), linkedinUrl);

        softAssert.assertAll();
    }
}
