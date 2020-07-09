package elalto.network.canchas.entities;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListarUserResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("mensaje")
    @Expose
    private String mensaje;
    @SerializedName("data")
    @Expose
    private List<UserCanchas> data = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ListarUserResponse() {
    }

    /**
     * 
     * @param data
     * @param mensaje
     * @param status
     */
    public ListarUserResponse(String status, String mensaje, List<UserCanchas> data) {
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

    public ListarUserResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ListarUserResponse withMensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    public List<UserCanchas> getData() {
        return data;
    }

    public void setData(List<UserCanchas> data) {
        this.data = data;
    }

    public ListarUserResponse withData(List<UserCanchas> data) {
        this.data = data;
        return this;
    }

}
