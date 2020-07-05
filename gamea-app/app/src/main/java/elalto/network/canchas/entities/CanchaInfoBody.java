package elalto.network.canchas.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CanchaInfoBody {

    @SerializedName("id_cancha")
    @Expose
    private String idCancha;

    /**
     * No args constructor for use in serialization
     *
     */
    public CanchaInfoBody() {
    }

    /**
     *
     * @param idCancha
     */
    public CanchaInfoBody(String idCancha) {
        super();
        this.idCancha = idCancha;
    }

    public String getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(String idCancha) {
        this.idCancha = idCancha;
    }

    public CanchaInfoBody withIdCancha(String idCancha) {
        this.idCancha = idCancha;
        return this;
    }

}