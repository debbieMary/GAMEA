package elalto.network.canchas.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserCanchas {

    @SerializedName("id_user")
    @Expose
    private Integer idUser;
    @SerializedName("ci")
    @Expose
    private Integer ci;
    @SerializedName("nombres")
    @Expose
    private String nombres;
    @SerializedName("apellidos")
    @Expose
    private String apellidos;
    @SerializedName("celular")
    @Expose
    private Integer celular;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("direccion")
    @Expose
    private String direccion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UserCanchas() {
    }

    /**
     * 
     * @param idUser
     * @param apellidos
     * @param ci
     * @param direccion
     * @param celular
     * @param email
     * @param nombres
     */
    public UserCanchas(Integer idUser, Integer ci, String nombres, String apellidos, Integer celular, String email, String direccion) {
        super();
        this.idUser = idUser;
        this.ci = ci;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.email = email;
        this.direccion = direccion;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public UserCanchas withIdUser(Integer idUser) {
        this.idUser = idUser;
        return this;
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public UserCanchas withCi(Integer ci) {
        this.ci = ci;
        return this;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public UserCanchas withNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public UserCanchas withApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public UserCanchas withCelular(Integer celular) {
        this.celular = celular;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserCanchas withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public UserCanchas withDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

}
