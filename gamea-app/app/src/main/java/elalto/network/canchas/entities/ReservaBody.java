package elalto.network.canchas.entities;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReservaBody {

    @SerializedName("id_cancha")
    @Expose
    private String idCancha;
    @SerializedName("id_usuario")
    @Expose
    private String idUsuario;
    @SerializedName("fecha_reserva")
    @Expose
    private String fechaReserva;
    @SerializedName("hora_inicio")
    @Expose
    private String horaInicio;
    @SerializedName("hora_fin")
    @Expose
    private String horaFin;
    @SerializedName("ci_quien_reserva")
    @Expose
    private String ciQuienReserva;
    @SerializedName("observaciones")
    @Expose
    private String observaciones;
    @SerializedName("modo_registro")
    @Expose
    private String modoRegistro;
    @SerializedName("nombre_reserva")
    @Expose
    private String nombreReserva;
    @SerializedName("estado")
    @Expose
    private String estado;
    @SerializedName("total")
    @Expose
    private Double total;

    /**
     * No args constructor for use in serialization
     *
     */
    public ReservaBody() {
    }

    /**
     *
     * @param horaFin
     * @param nombreReserva
     * @param estado
     * @param total
     * @param idUsuario
     * @param observaciones
     * @param ciQuienReserva
     * @param idCancha
     * @param horaInicio
     * @param fechaReserva
     * @param modoRegistro
     */
    public ReservaBody(String idCancha, String idUsuario, String fechaReserva, String horaInicio, String horaFin, String ciQuienReserva, String observaciones, String modoRegistro, String nombreReserva, String estado, Double total) {
        super();
        this.idCancha = idCancha;
        this.idUsuario = idUsuario;
        this.fechaReserva = fechaReserva;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.ciQuienReserva = ciQuienReserva;
        this.observaciones = observaciones;
        this.modoRegistro = modoRegistro;
        this.nombreReserva = nombreReserva;
        this.estado = estado;
        this.total = total;
    }

    public String getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(String idCancha) {
        this.idCancha = idCancha;
    }

    public ReservaBody withIdCancha(String idCancha) {
        this.idCancha = idCancha;
        return this;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ReservaBody withIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public ReservaBody withFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
        return this;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public ReservaBody withHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
        return this;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public ReservaBody withHoraFin(String horaFin) {
        this.horaFin = horaFin;
        return this;
    }

    public String getCiQuienReserva() {
        return ciQuienReserva;
    }

    public void setCiQuienReserva(String ciQuienReserva) {
        this.ciQuienReserva = ciQuienReserva;
    }

    public ReservaBody withCiQuienReserva(String ciQuienReserva) {
        this.ciQuienReserva = ciQuienReserva;
        return this;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public ReservaBody withObservaciones(String observaciones) {
        this.observaciones = observaciones;
        return this;
    }

    public String getModoRegistro() {
        return modoRegistro;
    }

    public void setModoRegistro(String modoRegistro) {
        this.modoRegistro = modoRegistro;
    }

    public ReservaBody withModoRegistro(String modoRegistro) {
        this.modoRegistro = modoRegistro;
        return this;
    }

    public String getNombreReserva() {
        return nombreReserva;
    }

    public void setNombreReserva(String nombreReserva) {
        this.nombreReserva = nombreReserva;
    }

    public ReservaBody withNombreReserva(String nombreReserva) {
        this.nombreReserva = nombreReserva;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ReservaBody withEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ReservaBody withTotal(Double total) {
        this.total = total;
        return this;
    }

}

