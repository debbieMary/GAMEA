package elalto.gamea.map.canchas.entities;

public class Cancha {

    /**
     * id_cancha : 1
     * nombre_cancha : Cancha Deportiva Rosas Pampa
     * lng : -68.17279158
     * lat : -16.54226215
     */

    private int id_cancha;
    private String nombre_cancha;
    private double lng;
    private double lat;
    private String distrito;
    private String direccion;
    private String telefono;


    public Cancha(int id_cancha, String nombre_cancha, double lng, double lat,  String distrito,  String direccion,  String telefono) {
        this.id_cancha= id_cancha;
        this.nombre_cancha= nombre_cancha;
        this.lng = lng;
        this.lat= lat;
        this.distrito= distrito;
        this.direccion= direccion;
        this.telefono=  telefono;
    }


    public int getId_cancha() { return id_cancha;}

    public void setId_cancha(int id_cancha) { this.id_cancha = id_cancha;}

    public String getNombre_cancha() { return nombre_cancha;}

    public void setNombre_cancha(String nombre_cancha) { this.nombre_cancha = nombre_cancha;}

    public double getLng() { return lng;}

    public void setLng(double lng) { this.lng = lng;}

    public double getLat() { return lat;}

    public void setLat(double lat) { this.lat = lat;}

    public String getDistrito() { return distrito;}
    public String getDireccion() { return direccion;}
    public String getTelefono() { return telefono;}


    public void setDistrito(String distrito) { this.distrito= distrito;}
    public void setDireccion(String direccion) { this.direccion= direccion;}
    public void setTelefono(String telefono) { this.telefono= telefono;}
}
