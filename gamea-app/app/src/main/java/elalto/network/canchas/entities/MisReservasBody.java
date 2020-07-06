package elalto.network.canchas.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MisReservasBody {

    @SerializedName("id_usuario")
    @Expose
    private String idUsuario;

    /**
     * No args constructor for use in serialization
     *
     */
    public MisReservasBody() {
    }

    /**
     *
     * @param idUsuario
     */
    public MisReservasBody(String idUsuario) {
        super();
        this.idUsuario = idUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public MisReservasBody withIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

}