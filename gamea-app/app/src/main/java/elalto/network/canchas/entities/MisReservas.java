package elalto.network.canchas.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MisReservas {

    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("distrito")
    @Expose
    private String distrito;
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
    public MisReservas() {
    }

    /**
     * 
     * @param distrito
     * @param estado
     * @param fechaAlta
     * @param idUsuario
     * @param ciQuienReserva
     * @param idUsuarioUpdate
     * @param nombre
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
    public MisReservas(String nombre, String distrito, Integer idReserva, Integer idCancha, Integer idUsuario, String fecha, String horaInicio, String horaFin, String ciQuienReserva, String observaciones, Integer modoRegistro, Integer estado, String fechaAlta, String fechaUpdate, String nombreReserva, Object idUsuarioUpdate, Integer total) {
        super();
        this.nombre = nombre;
        this.distrito = distrito;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MisReservas withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public MisReservas withDistrito(String distrito) {
        this.distrito = distrito;
        return this;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public MisReservas withIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
        return this;
    }

    public Integer getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(Integer idCancha) {
        this.idCancha = idCancha;
    }

    public MisReservas withIdCancha(Integer idCancha) {
        this.idCancha = idCancha;
        return this;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public MisReservas withIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public MisReservas withFecha(String fecha) {
        this.fecha = fecha;
        return this;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public MisReservas withHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
        return this;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public MisReservas withHoraFin(String horaFin) {
        this.horaFin = horaFin;
        return this;
    }

    public String getCiQuienReserva() {
        return ciQuienReserva;
    }

    public void setCiQuienReserva(String ciQuienReserva) {
        this.ciQuienReserva = ciQuienReserva;
    }

    public MisReservas withCiQuienReserva(String ciQuienReserva) {
        this.ciQuienReserva = ciQuienReserva;
        return this;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public MisReservas withObservaciones(String observaciones) {
        this.observaciones = observaciones;
        return this;
    }

    public Integer getModoRegistro() {
        return modoRegistro;
    }

    public void setModoRegistro(Integer modoRegistro) {
        this.modoRegistro = modoRegistro;
    }

    public MisReservas withModoRegistro(Integer modoRegistro) {
        this.modoRegistro = modoRegistro;
        return this;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public MisReservas withEstado(Integer estado) {
        this.estado = estado;
        return this;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public MisReservas withFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
        return this;
    }

    public String getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(String fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    public MisReservas withFechaUpdate(String fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
        return this;
    }

    public String getNombreReserva() {
        return nombreReserva;
    }

    public void setNombreReserva(String nombreReserva) {
        this.nombreReserva = nombreReserva;
    }

    public MisReservas withNombreReserva(String nombreReserva) {
        this.nombreReserva = nombreReserva;
        return this;
    }

    public Object getIdUsuarioUpdate() {
        return idUsuarioUpdate;
    }

    public void setIdUsuarioUpdate(Object idUsuarioUpdate) {
        this.idUsuarioUpdate = idUsuarioUpdate;
    }

    public MisReservas withIdUsuarioUpdate(Object idUsuarioUpdate) {
        this.idUsuarioUpdate = idUsuarioUpdate;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public MisReservas withTotal(Integer total) {
        this.total = total;
        return this;
    }

}
