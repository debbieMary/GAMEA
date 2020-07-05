package elalto.network.canchas.entities;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListadoCanchasResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("mensaje")
    @Expose
    private String mensaje;
    @SerializedName("data")
    @Expose
    private List<Cancha> data = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ListadoCanchasResponse() {
    }

    /**
     * 
     * @param data
     * @param mensaje
     * @param status
     */
    public ListadoCanchasResponse(String status, String mensaje, List<Cancha> data) {
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

    public ListadoCanchasResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ListadoCanchasResponse withMensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    public List<Cancha> getData() {
        return data;
    }

    public void setData(List<Cancha> data) {
        this.data = data;
    }

    public ListadoCanchasResponse withData(List<Cancha> data) {
        this.data = data;
        return this;
    }

}
