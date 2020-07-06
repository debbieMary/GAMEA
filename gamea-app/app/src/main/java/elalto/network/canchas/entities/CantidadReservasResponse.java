package elalto.network.canchas.entities;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CantidadReservasResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("mensaje")
    @Expose
    private String mensaje;
    @SerializedName("data")
    @Expose
    private List<CantidadReserva> data = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CantidadReservasResponse() {
    }

    /**
     * 
     * @param data
     * @param mensaje
     * @param status
     */
    public CantidadReservasResponse(String status, String mensaje, List<CantidadReserva> data) {
        super();
        this.status = status;
        this.mensaje = mensaje;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CantidadReservasResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public CantidadReservasResponse withMensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    public List<CantidadReserva> getData() {
        return data;
    }

    public void setData(List<CantidadReserva> data) {
        this.data = data;
    }

    public CantidadReservasResponse withData(List<CantidadReserva> data) {
        this.data = data;
        return this;
    }

}
