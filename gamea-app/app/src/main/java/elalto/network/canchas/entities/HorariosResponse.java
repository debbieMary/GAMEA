package elalto.network.canchas.entities;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HorariosResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("mensaje")
    @Expose
    private String mensaje;
    @SerializedName("data")
    @Expose
    private List<HorarioReservado> data = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public HorariosResponse() {
    }

    /**
     * 
     * @param data
     * @param mensaje
     * @param status
     */
    public HorariosResponse(String status, String mensaje, List<HorarioReservado> data) {
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

    public HorariosResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public HorariosResponse withMensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    public List<HorarioReservado> getData() {
        return data;
    }

    public void setData(List<HorarioReservado> data) {
        this.data = data;
    }

    public HorariosResponse withData(List<HorarioReservado> data) {
        this.data = data;
        return this;
    }

}
