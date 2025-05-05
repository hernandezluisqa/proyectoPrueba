package utilities;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private final static String screenshotPath = "src/test/resources/screenshots";
    private final static String pageSourcePath = "src/test/resources/pageStructure";

    public static void getScreenshot(String screeshotName){
        Logs.debug("Tomando screenshot");

        final var screenshotFile = ((TakesScreenshot) new WebDriverProvider().get()).getScreenshotAs(OutputType.FILE);

        final var path = String.format("%s/%s.png", screenshotPath, screeshotName);

        try{
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (IOException ioException){
            Logs.error("Error al tomar el screenshot: %s", ioException.getLocalizedMessage());
        }
    }

    public static void deletePreviousEvidence(){
        try{
            Logs.debug("Borrando evidencia anterior");
            FileUtils.deleteDirectory(new File(screenshotPath));
            FileUtils.deleteDirectory(new File(pageSourcePath));
        } catch (IOException ioException){
            Logs.error("Error al borrar la evidencia anterior: %s", ioException.getLocalizedMessage());
        }
    }

    @Attachment(value = "failureScreenshot", type = "image/png")
    public static byte[] getScreenshot(){
        return ((TakesScreenshot) new WebDriverProvider().get())
                .getScreenshotAs(OutputType.BYTES);
    }

    public static void getPageSource(String filename){

        Logs.debug("Tomando el page source de la pagina");
        final var path = String.format("%s/%s.html", pageSourcePath, filename);

        try{
            final var file = new File(path);

            Logs.debug("Creando los directorios padres sios es que no existen");
            if(file.getParentFile().mkdirs()){
                final var fileWriter = new FileWriter(file);
                final var pageSource = new WebDriverProvider().get().getPageSource();
                fileWriter.write(Jsoup.parse(pageSource).toString());
                fileWriter.close();
            }

        }catch (IOException ioException){
            Logs.error("Error al obtener el page source: %s", ioException.getLocalizedMessage());
        }
    }

    @Attachment(value = "pageSource", type = "text/html", fileExtension = "txt")
    public static Document getPageSource(){
        return Jsoup.parse(new WebDriverProvider().get().getPageSource().toString());
    }
}
