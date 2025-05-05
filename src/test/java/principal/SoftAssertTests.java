package principal;

import modelos.Monstruo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reader.ExcelReader;
import utilities.BaseTest;

import java.util.List;

public class SoftAssertTests extends BaseTest {
    private List<Monstruo> listaMonstruo;
    //Ver BaseTest en utilities

    @BeforeMethod
    public void setUp() {
        listaMonstruo = ExcelReader.obtenerListaMonstruos();
    }

    @Test
    public void primerSoftTest() {
        final var ultimoMonstruo = listaMonstruo.get(listaMonstruo.size() - 1);
        softAssert.assertEquals(ultimoMonstruo.getNombre(), "LUCENA");
        softAssert.assertEquals(ultimoMonstruo.getEdad(), 5, "El nivel obtenido no es el mismo que el esperado");
        softAssert.assertEquals(ultimoMonstruo.getPeso(), 8.57);
        softAssert.assertEquals(ultimoMonstruo.getGenero(), "MACHO");
        softAssert.assertEquals(ultimoMonstruo.getTipo(), "PLANTA");
        softAssert.assertEquals(ultimoMonstruo.getNivel(), 36);
        softAssert.assertAll();

    }

}
