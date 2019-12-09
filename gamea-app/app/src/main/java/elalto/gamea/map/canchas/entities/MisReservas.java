package elalto.gamea.map.canchas.entities;

public class MisReservas {

    public String nombre;
    public String distrito;
    public int id_reserva;
    public int id_cancha;
    public int id_usuario;
    public String fecha;
    public String hora_inicio;
    public String hora_fin;
    public String ci_quien_reserva;
    public String nombre_reserva;
    public String observaciones;
    public int modo_registro;
    public int estado;
    public String fecha_alta;
    public String fecha_update;


    public MisReservas(
        String nombre,
        String distrito,
        int id_reserva,
        int id_cancha,
        int id_usuario,
        String fecha,
        String hora_inicio,
        String hora_fin,
        String ci_quien_reserva,
        String nombre_reserva,
        String observaciones,
        int modo_registro,
        int estado,
        String fecha_alta,
        String fecha_update
    ) {
        this.nombre = nombre;
        this.distrito = distrito;
        this.id_reserva = id_reserva;
        this.id_cancha = id_cancha;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.ci_quien_reserva = ci_quien_reserva;
        this.nombre_reserva = nombre_reserva;
        this.observaciones = observaciones;
        this.modo_registro = modo_registro;
        this.estado = estado;
        this.fecha_alta = fecha_alta;
        this.fecha_update = fecha_update;
    }

    public String getNombre() {return  nombre;}
    public String getDistrito() {return  distrito;}
    public int getId_reserva() {return  id_reserva;}
    public int getId_cancha() {return  id_cancha;}
    public int getId_usuario() {return  id_usuario;}
    public String getFecha() {return  fecha;}
    public String getHora_inicio() {return  hora_inicio;}
    public String getHora_fin() {return  hora_fin;}
    public String getCi_quien_reserva() {return ci_quien_reserva ;}
    public String getNombre_reserva() {return nombre_reserva;}
    public String getObservaciones() {return observaciones ;}
    public int getModo_registro() {return  modo_registro;}
    public int getEstado() {return  estado;}
    public String getFecha_alta() {return  fecha_alta;}
    public String getFecha_update() {return fecha_update ;}

}
