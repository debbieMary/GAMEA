package elalto.network.canchas.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListarUserBody {

    @SerializedName("ci")
    @Expose
    private String ci;

    /**
     * No args constructor for use in serialization
     *
     */
    public ListarUserBody() {
    }

    /**
     *
     * @param ci
     */
    public ListarUserBody(String ci) {
        super();
        this.ci = ci;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public ListarUserBody withCi(String ci) {
        this.ci = ci;
        return this;
    }

}