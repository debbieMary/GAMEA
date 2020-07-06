package elalto.network.canchas.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HorariosBody {

    @SerializedName("id_cancha")
    @Expose
    private String idCancha;
    @SerializedName("fecha_inicio")
    @Expose
    private String fechaInicio;
    @SerializedName("fecha_fin")
    @Expose
    private String fechaFin;

    /**
     * No args constructor for use in serialization
     *
     */
    public HorariosBody() {
    }

    /**
     *
     * @param fechaInicio
     * @param fechaFin
     * @param idCancha
     */
    public HorariosBody(String idCancha, String fechaInicio, String fechaFin) {
        super();
        this.idCancha = idCancha;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(String idCancha) {
        this.idCancha = idCancha;
    }

    public HorariosBody withIdCancha(String idCancha) {
        this.idCancha = idCancha;
        return this;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public HorariosBody withFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public HorariosBody withFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
        return this;
    }

}