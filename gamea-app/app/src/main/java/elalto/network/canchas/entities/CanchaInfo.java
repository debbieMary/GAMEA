package elalto.network.canchas.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CanchaInfo {

    @SerializedName("id_cancha")
    @Expose
    private Integer idCancha;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("longitud")
    @Expose
    private Double longitud;
    @SerializedName("latitud")
    @Expose
    private Double latitud;
    @SerializedName("categoria")
    @Expose
    private String categoria;
    @SerializedName("tipo_escenario_deportivo")
    @Expose
    private String tipoEscenarioDeportivo;
    @SerializedName("tiene_perimetral")
    @Expose
    private String tienePerimetral;
    @SerializedName("tiene_tinglado_techo")
    @Expose
    private String tieneTingladoTecho;
    @SerializedName("tipo_pavimento")
    @Expose
    private String tipoPavimento;
    @SerializedName("se_encuentra")
    @Expose
    private String seEncuentra;
    @SerializedName("administrado_por")
    @Expose
    private String administradoPor;
    @SerializedName("graderias")
    @Expose
    private String graderias;
    @SerializedName("banos")
    @Expose
    private String banos;
    @SerializedName("camerinos")
    @Expose
    private String camerinos;
    @SerializedName("acceso_libre")
    @Expose
    private String accesoLibre;
    @SerializedName("quien_realizo")
    @Expose
    private Integer quienRealizo;
    @SerializedName("estado")
    @Expose
    private String estado;
    @SerializedName("distrito")
    @Expose
    private String distrito;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("fecha_Alta")
    @Expose
    private String fechaAlta;
    @SerializedName("usuario_alta")
    @Expose
    private String usuarioAlta;
    @SerializedName("foto1")
    @Expose
    private String foto1;
    @SerializedName("foto2")
    @Expose
    private String foto2;
    @SerializedName("foto3")
    @Expose
    private String foto3;
    @SerializedName("precio_hora")
    @Expose
    private Integer precioHora;
    @SerializedName("hora_inicio")
    @Expose
    private String horaInicio;
    @SerializedName("hora_fin")
    @Expose
    private String horaFin;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CanchaInfo() {
    }

    /**
     * 
     * @param quienRealizo
     * @param estado
     * @param tienePerimetral
     * @param tipoEscenarioDeportivo
     * @param tipoPavimento
     * @param nombre
     * @param horaFin
     * @param longitud
     * @param telefono
     * @param banos
     * @param distrito
     * @param latitud
     * @param tieneTingladoTecho
     * @param camerinos
     * @param fechaAlta
     * @param administradoPor
     * @param categoria
     * @param direccion
     * @param accesoLibre
     * @param usuarioAlta
     * @param idCancha
     * @param horaInicio
     * @param seEncuentra
     * @param graderias
     * @param precioHora
     * @param foto1
     * @param foto3
     * @param foto2
     */
    public CanchaInfo(Integer idCancha, String nombre, Double longitud, Double latitud, String categoria, String tipoEscenarioDeportivo, String tienePerimetral, String tieneTingladoTecho, String tipoPavimento, String seEncuentra, String administradoPor, String graderias, String banos, String camerinos, String accesoLibre, Integer quienRealizo, String estado, String distrito, String direccion, String telefono, String fechaAlta, String usuarioAlta, String foto1, String foto2, String foto3, Integer precioHora, String horaInicio, String horaFin) {
        super();
        this.idCancha = idCancha;
        this.nombre = nombre;
        this.longitud = longitud;
        this.latitud = latitud;
        this.categoria = categoria;
        this.tipoEscenarioDeportivo = tipoEscenarioDeportivo;
        this.tienePerimetral = tienePerimetral;
        this.tieneTingladoTecho = tieneTingladoTecho;
        this.tipoPavimento = tipoPavimento;
        this.seEncuentra = seEncuentra;
        this.administradoPor = administradoPor;
        this.graderias = graderias;
        this.banos = banos;
        this.camerinos = camerinos;
        this.accesoLibre = accesoLibre;
        this.quienRealizo = quienRealizo;
        this.estado = estado;
        this.distrito = distrito;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaAlta = fechaAlta;
        this.usuarioAlta = usuarioAlta;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.precioHora = precioHora;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Integer getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(Integer idCancha) {
        this.idCancha = idCancha;
    }

    public CanchaInfo withIdCancha(Integer idCancha) {
        this.idCancha = idCancha;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CanchaInfo withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public CanchaInfo withLongitud(Double longitud) {
        this.longitud = longitud;
        return this;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public CanchaInfo withLatitud(Double latitud) {
        this.latitud = latitud;
        return this;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public CanchaInfo withCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public String getTipoEscenarioDeportivo() {
        return tipoEscenarioDeportivo;
    }

    public void setTipoEscenarioDeportivo(String tipoEscenarioDeportivo) {
        this.tipoEscenarioDeportivo = tipoEscenarioDeportivo;
    }

    public CanchaInfo withTipoEscenarioDeportivo(String tipoEscenarioDeportivo) {
        this.tipoEscenarioDeportivo = tipoEscenarioDeportivo;
        return this;
    }

    public String getTienePerimetral() {
        return tienePerimetral;
    }

    public void setTienePerimetral(String tienePerimetral) {
        this.tienePerimetral = tienePerimetral;
    }

    public CanchaInfo withTienePerimetral(String tienePerimetral) {
        this.tienePerimetral = tienePerimetral;
        return this;
    }

    public String getTieneTingladoTecho() {
        return tieneTingladoTecho;
    }

    public void setTieneTingladoTecho(String tieneTingladoTecho) {
        this.tieneTingladoTecho = tieneTingladoTecho;
    }

    public CanchaInfo withTieneTingladoTecho(String tieneTingladoTecho) {
        this.tieneTingladoTecho = tieneTingladoTecho;
        return this;
    }

    public String getTipoPavimento() {
        return tipoPavimento;
    }

    public void setTipoPavimento(String tipoPavimento) {
        this.tipoPavimento = tipoPavimento;
    }

    public CanchaInfo withTipoPavimento(String tipoPavimento) {
        this.tipoPavimento = tipoPavimento;
        return this;
    }

    public String getSeEncuentra() {
        return seEncuentra;
    }

    public void setSeEncuentra(String seEncuentra) {
        this.seEncuentra = seEncuentra;
    }

    public CanchaInfo withSeEncuentra(String seEncuentra) {
        this.seEncuentra = seEncuentra;
        return this;
    }

    public String getAdministradoPor() {
        return administradoPor;
    }

    public void setAdministradoPor(String administradoPor) {
        this.administradoPor = administradoPor;
    }

    public CanchaInfo withAdministradoPor(String administradoPor) {
        this.administradoPor = administradoPor;
        return this;
    }

    public String getGraderias() {
        return graderias;
    }

    public void setGraderias(String graderias) {
        this.graderias = graderias;
    }

    public CanchaInfo withGraderias(String graderias) {
        this.graderias = graderias;
        return this;
    }

    public String getBanos() {
        return banos;
    }

    public void setBanos(String banos) {
        this.banos = banos;
    }

    public CanchaInfo withBanos(String banos) {
        this.banos = banos;
        return this;
    }

    public String getCamerinos() {
        return camerinos;
    }

    public void setCamerinos(String camerinos) {
        this.camerinos = camerinos;
    }

    public CanchaInfo withCamerinos(String camerinos) {
        this.camerinos = camerinos;
        return this;
    }

    public String getAccesoLibre() {
        return accesoLibre;
    }

    public void setAccesoLibre(String accesoLibre) {
        this.accesoLibre = accesoLibre;
    }

    public CanchaInfo withAccesoLibre(String accesoLibre) {
        this.accesoLibre = accesoLibre;
        return this;
    }

    public Integer getQuienRealizo() {
        return quienRealizo;
    }

    public void setQuienRealizo(Integer quienRealizo) {
        this.quienRealizo = quienRealizo;
    }

    public CanchaInfo withQuienRealizo(Integer quienRealizo) {
        this.quienRealizo = quienRealizo;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public CanchaInfo withEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public CanchaInfo withDistrito(String distrito) {
        this.distrito = distrito;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public CanchaInfo withDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public CanchaInfo withTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public CanchaInfo withFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
        return this;
    }

    public String getUsuarioAlta() {
        return usuarioAlta;
    }

    public void setUsuarioAlta(String usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public CanchaInfo withUsuarioAlta(String usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
        return this;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public CanchaInfo withFoto1(String foto1) {
        this.foto1 = foto1;
        return this;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public CanchaInfo withFoto2(String foto2) {
        this.foto2 = foto2;
        return this;
    }

    public String getFoto3() {
        return foto3;
    }

    public void setFoto3(String foto3) {
        this.foto3 = foto3;
    }

    public CanchaInfo withFoto3(String foto3) {
        this.foto3 = foto3;
        return this;
    }

    public Integer getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(Integer precioHora) {
        this.precioHora = precioHora;
    }

    public CanchaInfo withPrecioHora(Integer precioHora) {
        this.precioHora = precioHora;
        return this;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public CanchaInfo withHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
        return this;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public CanchaInfo withHoraFin(String horaFin) {
        this.horaFin = horaFin;
        return this;
    }

}
