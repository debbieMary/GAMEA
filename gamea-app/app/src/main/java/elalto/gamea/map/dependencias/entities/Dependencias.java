package elalto.gamea.map.dependencias.entities;

import java.io.Serializable;

public class Dependencias implements Serializable {

    /**
     * id_dependencia : 1
     * distrito : 1
     * zona : SANTIAGO I
     * direccion :  AV ARICA ENTRE CALLE 1 DETRÁS DEL CEMETERIO TARAPACA
     * secretaria : DESPACHO ALCALDESA
     * dependencia : DESPACHO ALCALDESA
     * lat : -16.527922
     * lng : -68.164981
     */

    private int id_dependencia;
    private int distrito;
    private String zona;
    private String direccion;
    private String secretaria;
    private String dependencia;
    private double lat;
    private double lng;

    public int getId_dependencia() { return id_dependencia;}

    public void setId_dependencia(int id_dependencia) { this.id_dependencia = id_dependencia;}

    public int getDistrito() { return distrito;}

    public void setDistrito(int distrito) { this.distrito = distrito;}

    public String getZona() { return zona;}

    public void setZona(String zona) { this.zona = zona;}

    public String getDireccion() { return direccion;}

    public void setDireccion(String direccion) { this.direccion = direccion;}

    public String getSecretaria() { return secretaria;}

    public void setSecretaria(String secretaria) { this.secretaria = secretaria;}

    public String getDependencia() { return dependencia;}

    public void setDependencia(String dependencia) { this.dependencia = dependencia;}

    public double getLat() { return lat;}

    public void setLat(double lat) { this.lat = lat;}

    public double getLng() { return lng;}

    public void setLng(double lng) { this.lng = lng;}
}
