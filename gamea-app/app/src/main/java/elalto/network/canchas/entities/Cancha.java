package elalto.network.canchas.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cancha {

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
    @SerializedName("distrito")
    @Expose
    private Object distrito;
    @SerializedName("direccion")
    @Expose
    private Object direccion;
    @SerializedName("telefono")
    @Expose
    private Object telefono;
    @SerializedName("precio_hora")
    @Expose
    private Object precioHora;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Cancha() {
    }

    /**
     * 
     * @param distrito
     * @param longitud
     * @param latitud
     * @param direccion
     * @param precioHora
     * @param telefono
     * @param nombre
     * @param idCancha
     */
    public Cancha(Integer idCancha, String nombre, Double longitud, Double latitud, Object distrito, Object direccion, Object telefono, Object precioHora) {
        super();
        this.idCancha = idCancha;
        this.nombre = nombre;
        this.longitud = longitud;
        this.latitud = latitud;
        this.distrito = distrito;
        this.direccion = direccion;
        this.telefono = telefono;
        this.precioHora = precioHora;
    }

    public Integer getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(Integer idCancha) {
        this.idCancha = idCancha;
    }

    public Cancha withIdCancha(Integer idCancha) {
        this.idCancha = idCancha;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cancha withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Cancha withLongitud(Double longitud) {
        this.longitud = longitud;
        return this;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Cancha withLatitud(Double latitud) {
        this.latitud = latitud;
        return this;
    }

    public Object getDistrito() {
        return distrito;
    }

    public void setDistrito(Object distrito) {
        this.distrito = distrito;
    }

    public Cancha withDistrito(Object distrito) {
        this.distrito = distrito;
        return this;
    }

    public Object getDireccion() {
        return direccion;
    }

    public void setDireccion(Object direccion) {
        this.direccion = direccion;
    }

    public Cancha withDireccion(Object direccion) {
        this.direccion = direccion;
        return this;
    }

    public Object getTelefono() {
        return telefono;
    }

    public void setTelefono(Object telefono) {
        this.telefono = telefono;
    }

    public Cancha withTelefono(Object telefono) {
        this.telefono = telefono;
        return this;
    }

    public Object getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(Object precioHora) {
        this.precioHora = precioHora;
    }

    public Cancha withPrecioHora(Object precioHora) {
        this.precioHora = precioHora;
        return this;
    }

}
