package elalto.gamea.artesano.categoria.model;

public class Categoria {

    /**
     * id_categoria : 2
     * categoria : METALMECANICA
     * descripcion : Productos trabajados artesanalmente en metalmecanica
     * imagen : img_categoria/hf4riTqJeilLr4J015XF4gmUcOE0XfGWoYR3PMal.jpeg
     * created_at : 2019-05-06 11:39:05
     * updated_at : 2019-05-06 11:39:05
     * estado : 1
     */

    private int id_categoria;
    private String categoria;
    private String descripcion;
    private String imagen;
    private String created_at;
    private String updated_at;
    private int estado;

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
