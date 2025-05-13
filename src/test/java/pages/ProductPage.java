package pages;

import org.openqa.selenium.By;
import utilities.BasePage;

public class ProductPage extends BasePage {
    private final By backToProductsButton = By.xpath("//Button[text()=\"Back to products\"]");
    private final By image = By.className("inventory_details_img");
    private final By price = By.className("inventory_details_price");
    private final By productName = By.className("inventory_details_name");
    private final By description = By.className("inventory_details");
    private final By addToCarButton = By.id("add-to-cart");


    @Override
    public void waitPageToLoad() {
        waitPage(image, this.getClass().getSimpleName());
        waitPage(backToProductsButton, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        final var backToProductsElement = find(backToProductsButton);
        final var imageElement = find(image);
        final var priceElement = find(price);
        final var nameElement = find(productName);
        final var descriptionElement = find(description);
        final var addToCartElement = find(addToCarButton);

        softAssert.assertTrue(backToProductsElement.isDisplayed());
        softAssert.assertTrue(imageElement.isDisplayed());
        softAssert.assertTrue(priceElement.isDisplayed());
        softAssert.assertTrue(nameElement.isDisplayed());
        softAssert.assertTrue(descriptionElement.isDisplayed());
        softAssert.assertTrue(addToCartElement.isDisplayed());
        softAssert.assertAll();
    }

    public void clickBackToProducts(){
        find(backToProductsButton).click();
    }
}
