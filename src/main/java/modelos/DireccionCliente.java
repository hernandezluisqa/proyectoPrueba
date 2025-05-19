package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DireccionCliente {
    @JsonProperty("calleNumero")
    private String calleNumero;
    @JsonProperty("dpto")
    private String dpto;
    @JsonProperty("referencia")
    private String referencia;

    public String getCalleNumero() {
        return calleNumero;
    }

    public String getDpto() {
        return dpto;
    }

    public String getReferencia() {
        return referencia;
    }
}
