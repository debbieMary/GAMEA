package elalto.gamea.map.hospitales.entities;

public class HospitalPoint {

    /**
     * id_hospital : 1
     * hospital : LOS ANDES
     * tipo : CENTRO DE SALUD
     * zona : HUAYNA POTOSI
     * lat : -68.19182971
     * lng : -16.4795214
     */

    private int id_hospital;
    private String hospital;
    private String tipo;
    private String zona;
    private double lat;
    private double lng;

    public int getId_hospital() { return id_hospital;}

    public void setId_hospital(int id_hospital) { this.id_hospital = id_hospital;}

    public String getHospital() { return hospital;}

    public void setHospital(String hospital) { this.hospital = hospital;}

    public String getTipo() { return tipo;}

    public void setTipo(String tipo) { this.tipo = tipo;}

    public String getZona() { return zona;}

    public void setZona(String zona) { this.zona = zona;}

    public double getLat() { return lat;}

    public void setLat(double lat) { this.lat = lat;}

    public double getLng() { return lng;}

    public void setLng(double lng) { this.lng = lng;}

}
