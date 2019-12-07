package elalto.gamea.catastro.consulta_tramite.entities;

import java.io.Serializable;
import java.util.List;

public class Tramite implements Serializable {


    /**
     * id_ingreso : 11621
     * hoja_ruta : SMDT-DAT-6785/2019
     * hoja_ruta_tipo : Externo
     * fecha_recepcion : null
     * numero_cite : 0
     * tramite : >1000m Zonificacion  de areas de Equipamientos
     * remitente : URB. 30 DE SEPTIEMBRE - HILARION HUANCA
     * cargo_remitente : null
     * referencia : null
     * cantidad_hojas : 4
     * nro_anexo : 0
     * derivaciones : [{"id_seguimiento":"47719","remitente":"URB. 30 DE SEPTIEMBRE - HILARION HUANCA<br>","fecha_derivada":"2019-02-06 15:32:22.567","destinatario":"Jose Manuel Soto Mamani<br>UNIDAD DE ADMINISTRACION TERRITORIAL","fecha_recibida":"2019-02-06 20:13:10.548+01","descripcion":"INICIO DE TRAMITE","estado":"Despachado","observaciones":"ninguno","fecha_ingreso":null,"estado_r":null,"observaciones_r":null},{"id_seguimiento":"48760","remitente":"Jose Manuel Soto Mamani<br>ASISTENTE VENTANILLA","fecha_derivada":"2019-02-08 20:22:50.159","destinatario":"Maria Edelmira Alcoreza Torrez<br>UNIDAD DE ADMINISTRACION TERRITORIAL","fecha_recibida":"2019-02-08 20:24:11.995+01","descripcion":"PROCEDER SEGUN LO ESTABLECIDO","estado":"Despachado","observaciones":"PARA SU ATENCION","fecha_ingreso":null,"estado_r":null,"observaciones_r":null},{"id_seguimiento":"52026","remitente":"Maria Edelmira Alcoreza Torrez<br>ASISTENTE B 1","fecha_derivada":"2019-02-20 13:14:15.745","destinatario":"Miguel  Angel Guzman Cornejo<br>UNIDAD DE ADMINISTRACION TERRITORIAL","fecha_recibida":"2019-02-20 13:22:51.045+01","descripcion":"PROCEDER SEGUN LO ESTABLECIDO","estado":"Despachado","observaciones":"SE ADJUNTA LA FOTOCOPIA LEGALIZADA DE LA RTA, PARA REMITIR A LA DAT","fecha_ingreso":null,"estado_r":null,"observaciones_r":null},{"id_seguimiento":"53371","remitente":"Miguel  Angel Guzman Cornejo<br>JEFE DE UNIDAD DE ADMINISTRACION TERRITORIAL","fecha_derivada":"2019-02-25 19:18:38.972","destinatario":"Nicol Dafne Quispe Miranda<br>DIRECCION DE ADMINISTRACION TERRITORIAL","fecha_recibida":"2019-02-26 16:38:23.511+01","descripcion":"PROCEDER SEGUN LO ESTABLECIDO","estado":"Despachado","observaciones":"PARA SU ATENCION","fecha_ingreso":null,"estado_r":null,"observaciones_r":null},{"id_seguimiento":"54356","remitente":"Nicol Dafne Quispe Miranda<br>APOYO ADMINISTRATIVO","fecha_derivada":"2019-02-27 16:56:03.578","destinatario":"AMED PETER HURTADO MENDOZA<br>DIRECCION DE ADMINISTRACION TERRITORIAL","fecha_recibida":"2019-02-27 19:22:00.203+01","descripcion":"PROCEDER SEGUN LO ESTABLECIDO","estado":"Terminado","observaciones":"PARA NOTIFICAR","fecha_ingreso":null,"estado_r":null,"observaciones_r":null}]
     * finalizacion : [{"id_seguimiento":"54356","fecha_salida":"2019-03-01 14:25:06.538+01","descripcion_final":"SE NOTIFICO AL SEÑOR HILARION HUANCA CUTILE CI: 2616904 LP."}]
     */

    private String id_ingreso;
    private String hoja_ruta;
    private String hoja_ruta_tipo;
    private String fecha_recepcion;
    private String numero_cite;
    private String tramite;
    private String remitente;
    private String cargo_remitente;
    private String referencia;
    private String cantidad_hojas;
    private String nro_anexo;
    private List<DerivacionesBean> derivaciones;
    private List<FinalizacionBean> finalizacion;

    public String getId_ingreso() { return id_ingreso;}

    public void setId_ingreso(String id_ingreso) { this.id_ingreso = id_ingreso;}

    public String getHoja_ruta() { return hoja_ruta;}

    public void setHoja_ruta(String hoja_ruta) { this.hoja_ruta = hoja_ruta;}

    public String getHoja_ruta_tipo() { return hoja_ruta_tipo;}

    public void setHoja_ruta_tipo(String hoja_ruta_tipo) { this.hoja_ruta_tipo = hoja_ruta_tipo;}

    public String getFecha_recepcion() { return fecha_recepcion;}

    public void setFecha_recepcion(String fecha_recepcion) { this.fecha_recepcion = fecha_recepcion;}

    public String getNumero_cite() { return numero_cite;}

    public void setNumero_cite(String numero_cite) { this.numero_cite = numero_cite;}

    public String getTramite() { return tramite;}

    public void setTramite(String tramite) { this.tramite = tramite;}

    public String getRemitente() { return remitente;}

    public void setRemitente(String remitente) { this.remitente = remitente;}

    public String getCargo_remitente() { return cargo_remitente;}

    public void setCargo_remitente(String cargo_remitente) { this.cargo_remitente = cargo_remitente;}

    public String getReferencia() { return referencia;}

    public void setReferencia(String referencia) { this.referencia = referencia;}

    public String getCantidad_hojas() { return cantidad_hojas;}

    public void setCantidad_hojas(String cantidad_hojas) { this.cantidad_hojas = cantidad_hojas;}

    public String getNro_anexo() { return nro_anexo;}

    public void setNro_anexo(String nro_anexo) { this.nro_anexo = nro_anexo;}

    public List<DerivacionesBean> getDerivaciones() { return derivaciones;}

    public void setDerivaciones(List<DerivacionesBean> derivaciones) { this.derivaciones = derivaciones;}

    public List<FinalizacionBean> getFinalizacion() { return finalizacion;}

    public void setFinalizacion(List<FinalizacionBean> finalizacion) { this.finalizacion = finalizacion;}

    public static class DerivacionesBean implements Serializable {
        /**
         * id_seguimiento : 47719
         * remitente : URB. 30 DE SEPTIEMBRE - HILARION HUANCA<br>
         * fecha_derivada : 2019-02-06 15:32:22.567
         * destinatario : Jose Manuel Soto Mamani<br>UNIDAD DE ADMINISTRACION TERRITORIAL
         * fecha_recibida : 2019-02-06 20:13:10.548+01
         * descripcion : INICIO DE TRAMITE
         * estado : Despachado
         * observaciones : ninguno
         * fecha_ingreso : null
         * estado_r : null
         * observaciones_r : null
         */

        private String id_seguimiento;
        private String remitente;
        private String fecha_derivada;
        private String destinatario;
        private String fecha_recibida;
        private String descripcion;
        private String estado;
        private String observaciones;
        private String fecha_ingreso;
        private String estado_r;
        private String observaciones_r;

        public String getId_seguimiento() { return id_seguimiento;}

        public void setId_seguimiento(String id_seguimiento) { this.id_seguimiento = id_seguimiento;}

        public String getRemitente() { return remitente;}

        public void setRemitente(String remitente) { this.remitente = remitente;}

        public String getFecha_derivada() { return fecha_derivada;}

        public void setFecha_derivada(String fecha_derivada) { this.fecha_derivada = fecha_derivada;}

        public String getDestinatario() { return destinatario;}

        public void setDestinatario(String destinatario) { this.destinatario = destinatario;}

        public String getFecha_recibida() { return fecha_recibida;}

        public void setFecha_recibida(String fecha_recibida) { this.fecha_recibida = fecha_recibida;}

        public String getDescripcion() { return descripcion;}

        public void setDescripcion(String descripcion) { this.descripcion = descripcion;}

        public String getEstado() { return estado;}

        public void setEstado(String estado) { this.estado = estado;}

        public String getObservaciones() { return observaciones;}

        public void setObservaciones(String observaciones) { this.observaciones = observaciones;}

        public String getFecha_ingreso() { return fecha_ingreso;}

        public void setFecha_ingreso(String fecha_ingreso) { this.fecha_ingreso = fecha_ingreso;}

        public String getEstado_r() { return estado_r;}

        public void setEstado_r(String estado_r) { this.estado_r = estado_r;}

        public String getObservaciones_r() { return observaciones_r;}

        public void setObservaciones_r(String observaciones_r) { this.observaciones_r = observaciones_r;}
    }

    public static class FinalizacionBean implements Serializable {
        /**
         * id_seguimiento : 54356
         * fecha_salida : 2019-03-01 14:25:06.538+01
         * descripcion_final : SE NOTIFICO AL SEÑOR HILARION HUANCA CUTILE CI: 2616904 LP.
         */

        private String id_seguimiento;
        private String fecha_salida;
        private String descripcion_final;

        public String getId_seguimiento() { return id_seguimiento;}

        public void setId_seguimiento(String id_seguimiento) { this.id_seguimiento = id_seguimiento;}

        public String getFecha_salida() { return fecha_salida;}

        public void setFecha_salida(String fecha_salida) { this.fecha_salida = fecha_salida;}

        public String getDescripcion_final() { return descripcion_final;}

        public void setDescripcion_final(String descripcion_final) { this.descripcion_final = descripcion_final;}
    }
}
