package elalto.gamea.map.modulosPoliciales.entities;

public class Modulos {
    /**
     * id_modulo : 1
     * nombre_modulo : 12 DE OCTUBRE
     * distrito : 1
     * zona : 12 DE OCTUBRE
     * direccion : Av. Rodolfo Palenque y Raul Salmon
     * telefono : 79675870
     * lat : -16.513552
     * lng : -68.163242
     */

    private int id_modulo;
    private String nombre_modulo;
    private int distrito;
    private String zona;
    private String direccion;
    private int telefono;
    private double lat;
    private double lng;

    public int getId_modulo() { return id_modulo;}

    public void setId_modulo(int id_modulo) { this.id_modulo = id_modulo;}

    public String getNombre_modulo() { return nombre_modulo;}

    public void setNombre_modulo(String nombre_modulo) { this.nombre_modulo = nombre_modulo;}

    public int getDistrito() { return distrito;}

    public void setDistrito(int distrito) { this.distrito = distrito;}

    public String getZona() { return zona;}

    public void setZona(String zona) { this.zona = zona;}

    public String getDireccion() { return direccion;}

    public void setDireccion(String direccion) { this.direccion = direccion;}

    public int getTelefono() { return telefono;}

    public void setTelefono(int telefono) { this.telefono = telefono;}

    public double getLat() { return lat;}

    public void setLat(double lat) { this.lat = lat;}

    public double getLng() { return lng;}

    public void setLng(double lng) { this.lng = lng;}
}
