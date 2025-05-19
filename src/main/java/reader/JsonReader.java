package reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import modelos.DatosCliente;
import modelos.EquiposAccesorios;

import java.io.File;
import java.io.IOException;

public class JsonReader {
    private final static String jsonPathTelefonosAccesorios = "src/main/resources/data/equiposAccesorios.json";
    private final static String JsonPathDatosCliente = "src/main/resources/data/datosCliente.json";

    public static EquiposAccesorios leerEquiposAccesoriosJson(){
        final var objectMapper = new ObjectMapper();
        try{
            return objectMapper.readValue(new File(jsonPathTelefonosAccesorios), EquiposAccesorios.class);
        } catch (IOException e){
            throw new RuntimeException("Error leyendo JSON", e);
        }
    }

    public static DatosCliente leerDatosClienteJson(){
        final var objectMapper = new ObjectMapper();
        try{
            return objectMapper.readValue(new File(JsonPathDatosCliente),DatosCliente.class);
        } catch (IOException e){
            throw new RuntimeException("Error leyendo JSON", e);
        }
    }
}
