package principal;

import data.CustomData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import modelos.Monstruo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reader.ExcelReader;
import utilities.BaseTest;

import java.util.List;

public class ExcelMonstruoTests extends BaseTest {
    private List<Monstruo> listaMonstruo;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        listaMonstruo = ExcelReader.obtenerListaMonstruos();
    }

    @Test(groups = {regression, smoke})
    public void primerTest() {
        final var primeroMonstruo = listaMonstruo.get(0);
        System.out.printf("El nombre del primer monstruo es: %s%n", primeroMonstruo.getNombre());
    }

    @Test(groups = {regression, smoke})
    public void segundoTest() {
        final var n = listaMonstruo.size();
        System.out.printf("El tamaño de la lista de monstruos es de %s monstruos%n", n);
    }

    @Test(groups = {regression})
    public void tercerTest() {
        final var tercerMonstruo = listaMonstruo.get(2);
        System.out.printf("El tercer monstruo llamado %s tiene un nivel de %d%n", tercerMonstruo.getNombre(), tercerMonstruo.getNivel());
    }

    @Test(dataProvider = CustomData.DP_NAME, dataProviderClass = CustomData.class, groups = {regression})
    @Description("Verificando las edades y nivel de los monstruos")
    @Severity(SeverityLevel.CRITICAL)
    public void cuartoTest(Monstruo monstruo) {
        softAssert.assertTrue(monstruo.getEdad() > 0);
        softAssert.assertTrue(monstruo.getNivel() < 100);
        softAssert.assertAll();
    }
}
