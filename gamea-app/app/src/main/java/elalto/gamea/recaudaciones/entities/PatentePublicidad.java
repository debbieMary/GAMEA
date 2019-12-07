package elalto.gamea.recaudaciones.entities;

public class PatentePublicidad {

    /**
     * id : 3
     * nom_razon : CALLE VILLALBA SANDRA
     * tipo_doc : CI
     * nro_doc : 6011027
     * expedido : LP
     * nro_tasa : 4045
     * nro_determinacion : 55755/2018
     * deuda_2012 : 0
     * deuda_2013 : 0
     * deuda_2014 : 221
     */

    private int id;
    private String nom_razon;
    private String tipo_doc;
    private String nro_doc;
    private String expedido;
    private String nro_tasa;
    private String nro_determinacion;
    private int deuda_2012;
    private int deuda_2013;
    private int deuda_2014;

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getNom_razon() { return nom_razon;}

    public void setNom_razon(String nom_razon) { this.nom_razon = nom_razon;}

    public String getTipo_doc() { return tipo_doc;}

    public void setTipo_doc(String tipo_doc) { this.tipo_doc = tipo_doc;}

    public String getNro_doc() { return nro_doc;}

    public void setNro_doc(String nro_doc) { this.nro_doc = nro_doc;}

    public String getExpedido() { return expedido;}

    public void setExpedido(String expedido) { this.expedido = expedido;}

    public String getNro_tasa() { return nro_tasa;}

    public void setNro_tasa(String nro_tasa) { this.nro_tasa = nro_tasa;}

    public String getNro_determinacion() { return nro_determinacion;}

    public void setNro_determinacion(String nro_determinacion) { this.nro_determinacion = nro_determinacion;}

    public int getDeuda_2012() { return deuda_2012;}

    public void setDeuda_2012(int deuda_2012) { this.deuda_2012 = deuda_2012;}

    public int getDeuda_2013() { return deuda_2013;}

    public void setDeuda_2013(int deuda_2013) { this.deuda_2013 = deuda_2013;}

    public int getDeuda_2014() { return deuda_2014;}

    public void setDeuda_2014(int deuda_2014) { this.deuda_2014 = deuda_2014;}
}
