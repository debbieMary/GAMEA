package elalto.network.canchas.entities;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MisReservasResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("mensaje")
    @Expose
    private String mensaje;
    @SerializedName("data")
    @Expose
    private List<MisReservas> data = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MisReservasResponse() {
    }

    /**
     * 
     * @param data
     * @param mensaje
     * @param status
     */
    public MisReservasResponse(String status, String mensaje, List<MisReservas> data) {
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

    public MisReservasResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public MisReservasResponse withMensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    public List<MisReservas> getData() {
        return data;
    }

    public void setData(List<MisReservas> data) {
        this.data = data;
    }

    public MisReservasResponse withData(List<MisReservas> data) {
        this.data = data;
        return this;
    }

}
