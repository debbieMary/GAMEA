package elalto.gamea.yayo.listperson.entities;

public class Desaparecido {

    /**
     * id_desaparecido : 3
     * ci_desaparecido : 123456
     * nombres_desaparecidos : JUANITO
     * apellidos_desaparecidos : PEREZ
     * edad : 54
     * genero : MASCULINO
     * tel_contacto : 71507474
     * desaparecio_inmediaciones : Cruce Villa adela distrito 1
     * detalles : Vestia con un abrigo rojo
     * lat : -16.54654
     * lng : -68.4654564
     * img : http://172.16.200.4/gamea-serve/public/storage/img_desaparecido/KAQDx7XhfQt3GmNyNtb1O4P0qiB6Kvef9FEHEHSx.jpeg
     * fecha_desaparicion : null
     * created_at : 2019-05-10 17:10:15
     * updated_at : 2019-05-10 17:10:15
     * id_user : 1
     * estado : 1
     * lovi : 1
     * usuario : {"usuario":"VICTOR HUGO ANAYA MAMANI","celular":71201978}
     * creado : hace 5 días
     */

    private int id_desaparecido;
    private int ci_desaparecido;
    private String nombres_desaparecidos;
    private String apellidos_desaparecidos;
    private int edad;
    private String genero;
    private int tel_contacto;
    private String desaparecio_inmediaciones;
    private String detalles;
    private double lat;
    private double lng;
    private String img;
    private Object fecha_desaparicion;
    private String created_at;
    private String updated_at;
    private int id_user;
    private int estado;
    private int lovi;
    private UsuarioBean usuario;
    private String creado;

    public int getId_desaparecido() { return id_desaparecido;}

    public void setId_desaparecido(int id_desaparecido) { this.id_desaparecido = id_desaparecido;}

    public int getCi_desaparecido() { return ci_desaparecido;}

    public void setCi_desaparecido(int ci_desaparecido) { this.ci_desaparecido = ci_desaparecido;}

    public String getNombres_desaparecidos() { return nombres_desaparecidos;}

    public void setNombres_desaparecidos(String nombres_desaparecidos) { this.nombres_desaparecidos = nombres_desaparecidos;}

    public String getApellidos_desaparecidos() { return apellidos_desaparecidos;}

    public void setApellidos_desaparecidos(String apellidos_desaparecidos) { this.apellidos_desaparecidos = apellidos_desaparecidos;}

    public int getEdad() { return edad;}

    public void setEdad(int edad) { this.edad = edad;}

    public String getGenero() { return genero;}

    public void setGenero(String genero) { this.genero = genero;}

    public int getTel_contacto() { return tel_contacto;}

    public void setTel_contacto(int tel_contacto) { this.tel_contacto = tel_contacto;}

    public String getDesaparecio_inmediaciones() { return desaparecio_inmediaciones;}

    public void setDesaparecio_inmediaciones(String desaparecio_inmediaciones) { this.desaparecio_inmediaciones = desaparecio_inmediaciones;}

    public String getDetalles() { return detalles;}

    public void setDetalles(String detalles) { this.detalles = detalles;}

    public double getLat() { return lat;}

    public void setLat(double lat) { this.lat = lat;}

    public double getLng() { return lng;}

    public void setLng(double lng) { this.lng = lng;}

    public String getImg() { return img;}

    public void setImg(String img) { this.img = img;}

    public Object getFecha_desaparicion() { return fecha_desaparicion;}

    public void setFecha_desaparicion(Object fecha_desaparicion) { this.fecha_desaparicion = fecha_desaparicion;}

    public String getCreated_at() { return created_at;}

    public void setCreated_at(String created_at) { this.created_at = created_at;}

    public String getUpdated_at() { return updated_at;}

    public void setUpdated_at(String updated_at) { this.updated_at = updated_at;}

    public int getId_user() { return id_user;}

    public void setId_user(int id_user) { this.id_user = id_user;}

    public int getEstado() { return estado;}

    public void setEstado(int estado) { this.estado = estado;}

    public int getLovi() { return lovi;}

    public void setLovi(int lovi) { this.lovi = lovi;}

    public UsuarioBean getUsuario() { return usuario;}

    public void setUsuario(UsuarioBean usuario) { this.usuario = usuario;}

    public String getCreado() { return creado;}

    public void setCreado(String creado) { this.creado = creado;}

    public static class UsuarioBean {
        /**
         * usuario : VICTOR HUGO ANAYA MAMANI
         * celular : 71201978
         */
        private String usuario;
        private int celular;

        public String getUsuario() { return usuario;}

        public void setUsuario(String usuario) { this.usuario = usuario;}

        public int getCelular() { return celular;}

        public void setCelular(int celular) { this.celular = celular;}
    }
}
