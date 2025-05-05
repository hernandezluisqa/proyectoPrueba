package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

import javax.swing.*;

public class VentanasPestanasTests extends BaseTest {
    @Test
    public void pestanasTest() {
        final var url = "https://www.tutorialspoint.com/selenium/practice/browser-windows.php";
        final var expectedText = "New Tab";
        final var expectedUrl = "https://www.tutorialspoint.com/selenium/practice/new-tab-sample.php";

        driver.get(url);
        final var tabID = driver.getWindowHandle();

        final var newTabButon = driver.findElement(By.cssSelector("button[title='New Tab']"));
        newTabButon.click();

        final var windowsHandlesSet = driver.getWindowHandles();
        for (var windowHandles : windowsHandlesSet) {
            if(!windowHandles.equals(tabID)){
                driver.switchTo().window(windowHandles);
            }
        }

        final var tittle = driver.findElement(By.xpath("//h1[text()='New Tab']")).getText();
        var gottenUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedText, tittle);
        Assert.assertEquals(expectedUrl, gottenUrl);

        driver.close();

        driver.switchTo().window(tabID);

        gottenUrl = driver.getCurrentUrl();
        Assert.assertEquals(url, gottenUrl);
    }

    @Test
    public void newWindowTest() {
        final var url = "https://www.tutorialspoint.com/selenium/practice/browser-windows.php";
        final var expectedTitleNewWindow = "New Window";

        driver.get(url);
        final var urlId = driver.getWindowHandle();
        Logs.debug("ID de pagina principal %s", urlId);

        final var newWindowElement = driver.findElement(By.xpath("//button[text()='New Window']"));
        newWindowElement.click();

        final var handles = driver.getWindowHandles();
        for (var handle : handles) {
            if (!handle.equals(urlId)){
                driver.switchTo().window(handle);
            }
        }
        driver.manage().window().maximize();

        final var titleNewWindow = driver.findElement(By.xpath("//h1[text()='New Window']")).getText();
        Assert.assertEquals(expectedTitleNewWindow, titleNewWindow);

        driver.close();

        driver.switchTo().window(urlId);

        Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Browser Windows']")).getText(), "Browser Windows");
    }

    @Test
    public void iFrameTest() {
        final var url = "https://www.tutorialspoint.com/selenium/practice/nestedframes.php";

        driver.get(url);

        driver.switchTo().frame("frame1"); //id

        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='New Tab']")).isDisplayed());

        driver.switchTo().defaultContent();

        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Nested Frames']")).isDisplayed());
    }

    @Test
    public void keysTest() {
        final var url = "https://demoqa.com/text-box";
        final var fullname = faker.name().fullName();

        driver.get(url);

        final var fullnameElement = driver.findElement(By.id("userName"));
        //fullnameElement.click();

        new Actions(driver)
                .click(fullnameElement) //podemos hacer click con actions method.
                .keyDown(Keys.SHIFT)
                .sendKeys(fullname)
                .keyDown(Keys.SHIFT)
                .perform();

        Assert.assertEquals(fullnameElement.getAttribute("value"), fullname.toUpperCase());
    }

    @Test
    public void keys2Test() {
        final var url = "https://demoqa.com/text-box";
        final var addressFaker = faker.address().fullAddress();

        driver.get(url);

        final var addressElement = driver.findElement(By.id("currentAddress"));
        addressElement.sendKeys(addressFaker);
        addressElement.click();

        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .perform();

        final var permanentAddressElement = driver.findElement(By.id("permanentAddress"));
        permanentAddressElement.click();

        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();

        Assert.assertEquals(addressElement.getAttribute("value"), permanentAddressElement.getAttribute("value"));
    }

    @Test
    public void droppedTest() {
        final var url = "https://demoqa.com/droppable";

        driver.get(url);

        final var dragableElement = driver.findElement(By.id("draggable"));
        final var dropableElement = driver.findElement(By.id("droppable"));

        new Actions(driver)
                .dragAndDrop(dragableElement, dropableElement)
                .perform();

        Assert.assertTrue(driver.findElement(By.xpath("//p[text()=\"Dropped!\"]")).isDisplayed());
    }
}
