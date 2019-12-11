package elalto.gamea.map.canchas.entities;

public class Horarios {



    private String fecha;
    private String hora;
    private String estado;


    public Horarios(String fecha, String hora ,  String estado) {
        this.fecha= fecha;
        this.hora= hora;
        this.estado = estado;
    }


    public String getFecha() { return fecha;}
    public String getHora() { return hora;}
    public String getEstado() { return estado;}
}
