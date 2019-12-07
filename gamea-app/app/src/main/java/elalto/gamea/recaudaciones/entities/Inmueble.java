package elalto.gamea.recaudaciones.entities;

public class Inmueble {

    /**
     * id : 2
     * nom_razon : ADJUDICATARIOS TRABAJADORES DE LA MINA CHOJLLA
     * doc_indentificacion : 14418871441867
     * nro_inmueble : 1510367615
     * nro_deter_mixta : 2/2018
     * deuda_2013 : 122
     * tipo_contribuyente : JURIDICO
     */

    private int id;
    private String nom_razon;
    private String doc_indentificacion;
    private String nro_inmueble;
    private String nro_deter_mixta;
    private int deuda_2013;
    private String tipo_contribuyente;

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getNom_razon() { return nom_razon;}

    public void setNom_razon(String nom_razon) { this.nom_razon = nom_razon;}

    public String getDoc_indentificacion() { return doc_indentificacion;}

    public void setDoc_indentificacion(String doc_indentificacion) { this.doc_indentificacion = doc_indentificacion;}

    public String getNro_inmueble() { return nro_inmueble;}

    public void setNro_inmueble(String nro_inmueble) { this.nro_inmueble = nro_inmueble;}

    public String getNro_deter_mixta() { return nro_deter_mixta;}

    public void setNro_deter_mixta(String nro_deter_mixta) { this.nro_deter_mixta = nro_deter_mixta;}

    public int getDeuda_2013() { return deuda_2013;}

    public void setDeuda_2013(int deuda_2013) { this.deuda_2013 = deuda_2013;}

    public String getTipo_contribuyente() { return tipo_contribuyente;}

    public void setTipo_contribuyente(String tipo_contribuyente) { this.tipo_contribuyente = tipo_contribuyente;}
}
