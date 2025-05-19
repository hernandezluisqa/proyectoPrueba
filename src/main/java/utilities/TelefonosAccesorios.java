package utilities;

import modelos.Accesorio;
import modelos.EquiposAccesorios;
import reader.JsonReader;
import modelos.Telefono;

public class TelefonosAccesorios {

    private static final EquiposAccesorios telefonosAccesorios = JsonReader.leerEquiposAccesoriosJson();

    static public Telefono obtenerTelefono(int position){
        final var telefonos = telefonosAccesorios.getTelefonos();
        return telefonos.get(position);
    }

    static public Accesorio obtenerAccesorio(int position){
        final var accesorios = telefonosAccesorios.getAccesorios();
        return accesorios.get(position);
    }
}
