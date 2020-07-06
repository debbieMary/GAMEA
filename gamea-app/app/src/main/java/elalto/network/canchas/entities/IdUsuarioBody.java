package elalto.network.canchas.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IdUsuarioBody {

    @SerializedName("id_usuario")
    @Expose
    private String idUsuario;

    /**
     * No args constructor for use in serialization
     *
     */
    public IdUsuarioBody() {
    }

    /**
     *
     * @param idUsuario
     */
    public IdUsuarioBody(String idUsuario) {
        super();
        this.idUsuario = idUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public IdUsuarioBody withIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

}