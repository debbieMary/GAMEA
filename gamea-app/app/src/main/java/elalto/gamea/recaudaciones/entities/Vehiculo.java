package elalto.gamea.recaudaciones.entities;

public class Vehiculo {

    /**
     * id : 3
     * nom_razon : COOP.DE TRANSP.CRUCENA LTDA
     * tipo_doc : RUC
     * nro_doc : 2056083
     * pta_poliza : 024XAG
     * nro_deter_mixta : 32414/2018
     * tipo_contribuyente : JURIDICO
     * deuda_2013 : 534
     */

    private int id;
    private String nom_razon;
    private String tipo_doc;
    private String nro_doc;
    private String placa;
    private String poliza;
    private String nro_deter_mixta;
    private String tipo_contribuyente;
    private int deuda_2013;

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getNom_razon() { return nom_razon;}

    public void setNom_razon(String nom_razon) { this.nom_razon = nom_razon;}

    public String getTipo_doc() { return tipo_doc;}

    public void setTipo_doc(String tipo_doc) { this.tipo_doc = tipo_doc;}

    public String getNro_doc() { return nro_doc;}

    public void setNro_doc(String nro_doc) { this.nro_doc = nro_doc;}

    public String getPlaca() { return placa;}

    public void setPlaca(String placa) { this.placa = placa;}

    public String getPoliza() { return poliza;}

    public void setPoliza(String poliza) { this.poliza = poliza;}

    public String getNro_deter_mixta() { return nro_deter_mixta;}

    public void setNro_deter_mixta(String nro_deter_mixta) { this.nro_deter_mixta = nro_deter_mixta;}

    public String getTipo_contribuyente() { return tipo_contribuyente;}

    public void setTipo_contribuyente(String tipo_contribuyente) { this.tipo_contribuyente = tipo_contribuyente;}

    public int getDeuda_2013() { return deuda_2013;}

    public void setDeuda_2013(int deuda_2013) { this.deuda_2013 = deuda_2013;}
}
