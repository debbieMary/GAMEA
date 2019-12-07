package elalto.models;

public class User {

    /**
     * iss : http://192.168.0.20/gamea-serve/public/api/auth/login
     * iat : 1557094302
     * exp : 1557097902
     * nbf : 1557094302
     * jti : WLKXYlyuPqzaWdxh
     * sub : 1
     * prv : 87e0af1ef9fd15812fdec97153a14e0b047546aa
     * id_user : 1
     * nombres : VICTOR HUGO
     * apellidos : ANAYA MAMANI
     */

    private String iss;
    private int iat;
    private int exp;
    private int nbf;
    private String jti;
    private int sub;
    private String prv;
    private int id_user;
    private String nombres;
    private String apellidos;

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public int getIat() {
        return iat;
    }

    public void setIat(int iat) {
        this.iat = iat;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNbf() {
        return nbf;
    }

    public void setNbf(int nbf) {
        this.nbf = nbf;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public int getSub() {
        return sub;
    }

    public void setSub(int sub) {
        this.sub = sub;
    }

    public String getPrv() {
        return prv;
    }

    public void setPrv(String prv) {
        this.prv = prv;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
