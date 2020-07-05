package elalto.network.canchas.entities;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CanchaInfoResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("mensaje")
    @Expose
    private String mensaje;
    @SerializedName("data")
    @Expose
    private List<CanchaInfo> data = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CanchaInfoResponse() {
    }

    /**
     * 
     * @param data
     * @param mensaje
     * @param status
     */
    public CanchaInfoResponse(String status, String mensaje, List<CanchaInfo> data) {
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

    public CanchaInfoResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public CanchaInfoResponse withMensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    public List<CanchaInfo> getData() {
        return data;
    }

    public void setData(List<CanchaInfo> data) {
        this.data = data;
    }

    public CanchaInfoResponse withData(List<CanchaInfo> data) {
        this.data = data;
        return this;
    }

}
