package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DatosCliente {

    @JsonProperty("nombre")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("direccion")
    private DireccionCliente direccion;
    @JsonProperty("rut")
    private String rut;

    public String getTelefono() {
        return telefono;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public DireccionCliente getDireccion() {
        return direccion;
    }

    public String getRut() {
        return rut;
    }
}
