package elalto.gamea.denuncia.misreportes.entities;

public class Denuncia {

    /**
     * id_denuncia : 16
     * distrito : 14
     * zona : Río Seco
     * descripcion : Luminarias Encendidas En El Día
     * img_denuncia : http://172.16.200.4/gamea-serve/public/storage/test
     * fecha_publicacion : 2019-05-17 17:46:39
     * estado : 1
     * nombre_secretaria : SECRETARIA MUNICIPAL DE SEGURIDAD CIUDADANA
     * publicado : hace 2 días
     */

    private int id_denuncia;
    private int distrito;
    private String zona;
    private String descripcion;
    private String img_denuncia;
    private String fecha_publicacion;
    private String estado;
    private String nombre_secretaria;
    private String publicado;

    public int getId_denuncia() { return id_denuncia;}

    public void setId_denuncia(int id_denuncia) { this.id_denuncia = id_denuncia;}

    public int getDistrito() { return distrito;}

    public void setDistrito(int distrito) { this.distrito = distrito;}

    public String getZona() { return zona;}

    public void setZona(String zona) { this.zona = zona;}

    public String getDescripcion() { return descripcion;}

    public void setDescripcion(String descripcion) { this.descripcion = descripcion;}

    public String getImg_denuncia() { return img_denuncia;}

    public void setImg_denuncia(String img_denuncia) { this.img_denuncia = img_denuncia;}

    public String getFecha_publicacion() { return fecha_publicacion;}

    public void setFecha_publicacion(String fecha_publicacion) { this.fecha_publicacion = fecha_publicacion;}

    public String getEstado() { return estado;}

    public void setEstado(String estado) { this.estado = estado;}

    public String getNombre_secretaria() { return nombre_secretaria;}

    public void setNombre_secretaria(String nombre_secretaria) { this.nombre_secretaria = nombre_secretaria;}

    public String getPublicado() { return publicado;}

    public void setPublicado(String publicado) { this.publicado = publicado;}
}
