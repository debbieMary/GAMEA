package elalto.gamea.testviolencia.dondeacudir;

import java.io.Serializable;

public class Ubicaciones implements Serializable {

    /**
     * id : 1
     * nombre : vicente lema pisarosa
     * distrito : 1
     * direccion : Av. Civica/calle4
     * celular : 76726803
     * lat : -16.536053
     * lng : -68.165881
     * tipo : AIDAJ
     */

    private int id;
    private String nombre;
    private int distrito;
    private String direccion;
    private int celular;
    private double lat;
    private double lng;
    private String tipo;

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getNombre() { return nombre;}

    public void setNombre(String nombre) { this.nombre = nombre;}

    public int getDistrito() { return distrito;}

    public void setDistrito(int distrito) { this.distrito = distrito;}

    public String getDireccion() { return direccion;}

    public void setDireccion(String direccion) { this.direccion = direccion;}

    public int getCelular() { return celular;}

    public void setCelular(int celular) { this.celular = celular;}

    public double getLat() { return lat;}

    public void setLat(double lat) { this.lat = lat;}

    public double getLng() { return lng;}

    public void setLng(double lng) { this.lng = lng;}

    public String getTipo() { return tipo;}

    public void setTipo(String tipo) { this.tipo = tipo;}
}
