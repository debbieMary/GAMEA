package elalto.network.canchas.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HorarioReservado {

    @SerializedName("id_reserva")
    @Expose
    private Integer idReserva;
    @SerializedName("id_cancha")
    @Expose
    private Integer idCancha;
    @SerializedName("id_usuario")
    @Expose
    private Integer idUsuario;
    @SerializedName("fecha")
    @Expose
    private String fecha;
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
    private Integer modoRegistro;
    @SerializedName("estado")
    @Expose
    private Integer estado;
    @SerializedName("fecha_alta")
    @Expose
    private String fechaAlta;
    @SerializedName("fecha_update")
    @Expose
    private String fechaUpdate;
    @SerializedName("nombre_reserva")
    @Expose
    private String nombreReserva;
    @SerializedName("id_usuario_update")
    @Expose
    private Object idUsuarioUpdate;
    @SerializedName("total")
    @Expose
    private Integer total;

    /**
     * No args constructor for use in serialization
     * 
     */
    public HorarioReservado() {
    }

    /**
     * 
     * @param estado
     * @param fechaAlta
     * @param idUsuario
     * @param ciQuienReserva
     * @param idUsuarioUpdate
     * @param fechaUpdate
     * @param idCancha
     * @param horaInicio
     * @param horaFin
     * @param fecha
     * @param nombreReserva
     * @param total
     * @param observaciones
     * @param idReserva
     * @param modoRegistro
     */
    public HorarioReservado(Integer idReserva, Integer idCancha, Integer idUsuario, String fecha, String horaInicio, String horaFin, String ciQuienReserva, String observaciones, Integer modoRegistro, Integer estado, String fechaAlta, String fechaUpdate, String nombreReserva, Object idUsuarioUpdate, Integer total) {
        super();
        this.idReserva = idReserva;
        this.idCancha = idCancha;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.ciQuienReserva = ciQuienReserva;
        this.observaciones = observaciones;
        this.modoRegistro = modoRegistro;
        this.estado = estado;
        this.fechaAlta = fechaAlta;
        this.fechaUpdate = fechaUpdate;
        this.nombreReserva = nombreReserva;
        this.idUsuarioUpdate = idUsuarioUpdate;
        this.total = total;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public HorarioReservado withIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
        return this;
    }

    public Integer getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(Integer idCancha) {
        this.idCancha = idCancha;
    }

    public HorarioReservado withIdCancha(Integer idCancha) {
        this.idCancha = idCancha;
        return this;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public HorarioReservado withIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public HorarioReservado withFecha(String fecha) {
        this.fecha = fecha;
        return this;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public HorarioReservado withHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
        return this;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public HorarioReservado withHoraFin(String horaFin) {
        this.horaFin = horaFin;
        return this;
    }

    public String getCiQuienReserva() {
        return ciQuienReserva;
    }

    public void setCiQuienReserva(String ciQuienReserva) {
        this.ciQuienReserva = ciQuienReserva;
    }

    public HorarioReservado withCiQuienReserva(String ciQuienReserva) {
        this.ciQuienReserva = ciQuienReserva;
        return this;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public HorarioReservado withObservaciones(String observaciones) {
        this.observaciones = observaciones;
        return this;
    }

    public Integer getModoRegistro() {
        return modoRegistro;
    }

    public void setModoRegistro(Integer modoRegistro) {
        this.modoRegistro = modoRegistro;
    }

    public HorarioReservado withModoRegistro(Integer modoRegistro) {
        this.modoRegistro = modoRegistro;
        return this;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public HorarioReservado withEstado(Integer estado) {
        this.estado = estado;
        return this;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public HorarioReservado withFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
        return this;
    }

    public String getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(String fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    public HorarioReservado withFechaUpdate(String fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
        return this;
    }

    public String getNombreReserva() {
        return nombreReserva;
    }

    public void setNombreReserva(String nombreReserva) {
        this.nombreReserva = nombreReserva;
    }

    public HorarioReservado withNombreReserva(String nombreReserva) {
        this.nombreReserva = nombreReserva;
        return this;
    }

    public Object getIdUsuarioUpdate() {
        return idUsuarioUpdate;
    }

    public void setIdUsuarioUpdate(Object idUsuarioUpdate) {
        this.idUsuarioUpdate = idUsuarioUpdate;
    }

    public HorarioReservado withIdUsuarioUpdate(Object idUsuarioUpdate) {
        this.idUsuarioUpdate = idUsuarioUpdate;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public HorarioReservado withTotal(Integer total) {
        this.total = total;
        return this;
    }

}
