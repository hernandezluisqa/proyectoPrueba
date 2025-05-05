package reader;

import com.poiji.bind.Poiji;
import modelos.Monstruo;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private final static String monstruosExcelPath = "src/main/resources/data/dataExcel.xlsx";

    public static List<Monstruo> obtenerListaMonstruos() {
        return Poiji.fromExcel(new File(monstruosExcelPath), Monstruo.class);
    }
}
