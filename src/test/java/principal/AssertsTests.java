package principal;

import modelos.Monstruo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reader.ExcelReader;
import utilities.BaseTest;

import java.util.List;

public class AssertsTests extends BaseTest {
    private List<Monstruo> listaMonstruo;

    @BeforeMethod
    public void setUp() {
        listaMonstruo = ExcelReader.obtenerListaMonstruos();
    }

    @Test
    public void primerTest() {
        final var primeroMonstruo = listaMonstruo.get(0);
        Assert.assertEquals(primeroMonstruo.getNombre(), "TOLOSA", "El nombre obtenido no es igual a TOLOSA");
    }

    @Test
    public void segundoTest() {
        final var n = listaMonstruo.size();
        Assert.assertEquals(n, 14, "La longitus esperada no es igual a 14");

    }

    @Test
    public void tercerTest() {
        final var tercerMonstruo = listaMonstruo.get(2);
        Assert.assertEquals(tercerMonstruo.getNivel(), 22, "El nivel del 3er monstruo no es igual al esperado");
    }
}
