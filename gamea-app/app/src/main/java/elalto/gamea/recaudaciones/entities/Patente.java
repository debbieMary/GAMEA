package elalto.gamea.recaudaciones.entities;

public class Patente {

    /**
     * id : 8
     * nom_razon : ALBA TRADING S.R.L.
     * tipo_doc : RUC
     * nro_doc : 10171525
     * nro_deter_mixta : 54644/2018
     * deuda_2014 : 1736
     * tipo_contribuyente : JURIDICO
     */

    private int id;
    private String nom_razon;
    private String tipo_doc;
    private String nro_doc;
    private String nro_deter_mixta;
    private int deuda_2014;
    private String tipo_contribuyente;

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getNom_razon() { return nom_razon;}

    public void setNom_razon(String nom_razon) { this.nom_razon = nom_razon;}

    public String getTipo_doc() { return tipo_doc;}

    public void setTipo_doc(String tipo_doc) { this.tipo_doc = tipo_doc;}

    public String getNro_doc() { return nro_doc;}

    public void setNro_doc(String nro_doc) { this.nro_doc = nro_doc;}

    public String getNro_deter_mixta() { return nro_deter_mixta;}

    public void setNro_deter_mixta(String nro_deter_mixta) { this.nro_deter_mixta = nro_deter_mixta;}

    public int getDeuda_2014() { return deuda_2014;}

    public void setDeuda_2014(int deuda_2014) { this.deuda_2014 = deuda_2014;}

    public String getTipo_contribuyente() { return tipo_contribuyente;}

    public void setTipo_contribuyente(String tipo_contribuyente) { this.tipo_contribuyente = tipo_contribuyente;}
}
