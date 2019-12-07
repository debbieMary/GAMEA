package elalto.gamea.map.canchas.entities;

public class CanchaCobro {


    private int id_cobro;
    private String nombre_cobro;
    private double latitud;
    private double longitud;
    private String telefono;
    private String direccion;

    public CanchaCobro(int id_cobro , String nombre_cobro,  double latitud, double longitud, String telefono,  String direccion) {
        this.id_cobro= id_cobro;
        this.nombre_cobro= nombre_cobro;
        this.latitud = latitud;
        this.longitud= longitud;
        this.telefono= telefono;
        this.direccion= direccion;
    }


    public int getId_cobro() { return id_cobro;}
    public void setId_cobro(int id_cobro) { this.id_cobro = id_cobro;}

    public String getNombre_cobro() { return nombre_cobro;}
    public void setNombre_cobro(String nombre_cobro) { this.nombre_cobro = nombre_cobro;}

    public double getLatitud() { return latitud;}
    public void setLatitud(double latitud) { this.latitud = latitud;}

    public double getLongitud() { return longitud;}
    public void setLongitud(double longitud) { this.longitud = longitud;}

    public String getTelefono() { return telefono;}
    public void setTelefono(String telefono) { this.telefono = telefono;}

    public String getDireccion() { return direccion;}
    public void setDireccion(String direccion) { this.direccion = direccion;}

}
