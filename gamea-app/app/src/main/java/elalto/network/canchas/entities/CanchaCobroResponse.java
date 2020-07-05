package elalto.network.canchas.entities;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CanchaCobroResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("mensaje")
    @Expose
    private String mensaje;
    @SerializedName("data")
    @Expose
    private List<CanchaCobro> data = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CanchaCobroResponse() {
    }

    /**
     * 
     * @param data
     * @param mensaje
     * @param status
     */
    public CanchaCobroResponse(String status, String mensaje, List<CanchaCobro> data) {
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

    public CanchaCobroResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public CanchaCobroResponse withMensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    public List<CanchaCobro> getData() {
        return data;
    }

    public void setData(List<CanchaCobro> data) {
        this.data = data;
    }

    public CanchaCobroResponse withData(List<CanchaCobro> data) {
        this.data = data;
        return this;
    }

}
