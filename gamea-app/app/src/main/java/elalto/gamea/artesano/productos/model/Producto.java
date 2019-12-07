package elalto.gamea.artesano.productos.model;

public class Producto {

    /**
     * id_productos : 1
     * producto : REJA METALICA
     * descripcion : Reja para puertas de ingreso
     * precio : 750
     * img1 : img_categoria/gyaSWWPM8MRDPrIkuiUFzvIpSIrt5Ea6AXI56HkB.jpeg
     * img2 : img_categoria/2UsIUBRIVftEqnTvuqct2cBJxZu1OYtmBvNZ2pWh.jpeg
     * img3 : img_categoria/2niRYJ3UNzzDUYJm6i3dIpKXKu3hYCMZsODbum3m.jpeg
     * artesano : JUAN JOSE TORREZ
     * telefono : 74000672
     * distrito : 1
     * direccion : El Alto distrito 1 Plaza 21 de Diciembre #255
     * lat : -16.525519
     * lng : -68.187247
     */

    private int id_productos;
    private String producto;
    private String descripcion;
    private int precio;
    private String img1;
    private String img2;
    private String img3;
    private String artesano;
    private int telefono;
    private int distrito;
    private String direccion;
    private double lat;
    private double lng;

    public int getId_productos() {
        return id_productos;
    }

    public void setId_productos(int id_productos) {
        this.id_productos = id_productos;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getArtesano() {
        return artesano;
    }

    public void setArtesano(String artesano) {
        this.artesano = artesano;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getDistrito() {
        return distrito;
    }

    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
