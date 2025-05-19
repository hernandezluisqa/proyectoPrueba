package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EquiposAccesorios {
    @JsonProperty("telefonos")
    private List<Telefono> telefonos ;
    @JsonProperty("accesorios")
    private List<Accesorio> accesorios;

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public List<Accesorio> getAccesorios() {
        return accesorios;
    }
}

