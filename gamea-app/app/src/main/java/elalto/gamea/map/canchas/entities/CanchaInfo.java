package elalto.gamea.map.canchas.entities;


public class CanchaInfo {

    private int    id_cancha;
    private String nombre;
    private String categoria;
    private double longitud;
    private double latitud;
    private String tipo_escenario_deportivo;
    private String tiene_perimetral;
    private String tiene_tinglado_techo;
    private String tipo_pavimento;
    private String se_encuentra;
    private String administrado_por;
    private String graderias;
    private String banos;
    private String camerinos;
    private String acceso_libre;
    private String quien_realizo;
    private String estado;
    private String distrito;
    private String direccion;
    private String telefono;
    private String foto1;
    private String foto2;
    private String foto3;
    private String fecha_Alta;
    private String usuario_alta;
    private String hora_inicio;
    private String hora_fin;

    public CanchaInfo(
            int id_cancha,
            String nombre,
            String categoria,
            double longitud,
            double latitud,
            String tipo_escenario_deportivo,
            String tiene_perimetral,
            String tiene_tinglado_techo,
            String tipo_pavimento,
            String se_encuentra,
            String administrado_por,
            String graderias,
            String banos,
            String camerinos,
            String acceso_libre,
            String quien_realizo,
            String estado,
            String distrito,
            String direccion,
            String telefono,
            String foto1,
            String foto2,
            String foto3,
            String fecha_Alta,
            String usuario_alta,
            String hora_inicio,
            String hora_fin
    ) {
        this.id_cancha= id_cancha;
        this.nombre = nombre;
        this.categoria = categoria;
        this.longitud = longitud;
        this.latitud = latitud;
        this.tipo_escenario_deportivo = tipo_escenario_deportivo;
        this.tiene_perimetral = tiene_perimetral;
        this.tiene_tinglado_techo = tiene_tinglado_techo;
        this.tipo_pavimento = tipo_pavimento;
        this.se_encuentra = se_encuentra;
        this.administrado_por = administrado_por;
        this.graderias = graderias;
        this.banos = banos;
        this.camerinos = camerinos;
        this.acceso_libre = acceso_libre;
        this.quien_realizo = quien_realizo;
        this.estado = estado;
        this.distrito = distrito;
        this.direccion = direccion;
        this.telefono = telefono;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.fecha_Alta = fecha_Alta;
        this.usuario_alta = usuario_alta;
        this.hora_inicio= hora_inicio;
        this.hora_fin=  hora_fin;
    }
    public int getId_cancha(){return id_cancha;}
    public String getNombre(){return nombre;}
    public String getCategoria(){return categoria;}
    public double getLongitud(){return longitud;}
    public double getLatitud(){return latitud ;}
    public String getTipo_escenario_deportivo(){return tipo_escenario_deportivo ;}
    public String getTiene_perimetral(){return tiene_perimetral;}
    public String getTiene_tinglado_techo(){return tiene_tinglado_techo;}
    public String getTipo_pavimento(){return tipo_pavimento;}
    public String getSe_encuentra(){return se_encuentra;}
    public String getAdministrado_por(){return administrado_por;}
    public String getGraderias(){return graderias;}
    public String getBanos(){return banos;}
    public String getCamerinos(){return camerinos;}
    public String getAcceso_libre(){return acceso_libre;}
    public String getQuien_realizo(){return quien_realizo;}
    public String getEstado(){return estado;}
    public String getDistrito(){return distrito;}
    public String getDireccion(){return direccion;}
    public String getTelefono (){return telefono;}
    public String getFoto1(){return foto1;}
    public String getFoto2(){return foto2;}
    public String getFoto3(){return foto3;}
    public String getFecha_Alta(){return fecha_Alta;}
    public String getUsuario_alta(){return usuario_alta;}
    public String getHora_inicio(){return hora_inicio;}
    public String getHora_fin(){return hora_fin;}
}

