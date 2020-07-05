package elalto.network.canchas.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CanchaCobro {

    @SerializedName("id_cobro")
    @Expose
    private Integer idCobro;
    @SerializedName("nombre_cobro")
    @Expose
    private String nombreCobro;
    @SerializedName("latitud")
    @Expose
    private Double latitud;
    @SerializedName("longitud")
    @Expose
    private Double longitud;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("direccion")
    @Expose
    private String direccion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CanchaCobro() {
    }

    /**
     * 
     * @param latitud
     * @param longitud
     * @param direccion
     * @param telefono
     * @param nombreCobro
     * @param idCobro
     */
    public CanchaCobro(Integer idCobro, String nombreCobro, Double latitud, Double longitud, String telefono, String direccion) {
        super();
        this.idCobro = idCobro;
        this.nombreCobro = nombreCobro;
        this.latitud = latitud;
        this.longitud = longitud;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Integer getIdCobro() {
        return idCobro;
    }

    public void setIdCobro(Integer idCobro) {
        this.idCobro = idCobro;
    }

    public CanchaCobro withIdCobro(Integer idCobro) {
        this.idCobro = idCobro;
        return this;
    }

    public String getNombreCobro() {
        return nombreCobro;
    }

    public void setNombreCobro(String nombreCobro) {
        this.nombreCobro = nombreCobro;
    }

    public CanchaCobro withNombreCobro(String nombreCobro) {
        this.nombreCobro = nombreCobro;
        return this;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public CanchaCobro withLatitud(Double latitud) {
        this.latitud = latitud;
        return this;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public CanchaCobro withLongitud(Double longitud) {
        this.longitud = longitud;
        return this;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public CanchaCobro withTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public CanchaCobro withDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

}
