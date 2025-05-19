package utilities;

import modelos.DatosCliente;
import reader.JsonReader;

public class DatosC {
    private static final DatosCliente datosCliente = JsonReader.leerDatosClienteJson();

    public static DatosCliente datosCliente(){
        return datosCliente;
    }
}
