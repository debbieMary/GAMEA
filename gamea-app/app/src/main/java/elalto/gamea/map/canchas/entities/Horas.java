package elalto.gamea.map.canchas.entities;

public class Horas {


    public int hora;
    public int estado;

    public Horas(int hora,  int estado) {
        this.hora= hora;
        this.estado= estado;
    }

    public int getHora() { return hora;}
    public void setHora(int hora) { this.hora = hora;}

    public int getEstadoHora() { return estado;}
    public void setEstadoHora(int estado) { this.estado = estado;}
}
