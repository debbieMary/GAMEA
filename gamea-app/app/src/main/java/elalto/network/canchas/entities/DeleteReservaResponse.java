package elalto.network.canchas.entities;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeleteReservaResponse {

    @SerializedName("resultado")
    @Expose
    private Boolean resultado;
    @SerializedName("mensaje")
    @Expose
    private String mensaje;
    @SerializedName("id_reserva")
    @Expose
    private Integer idReserva;

    /**
     * No args constructor for use in serialization
     *
     */
    public DeleteReservaResponse() {
    }

    /**
     *
     * @param resultado
     * @param mensaje
     * @param idReserva
     */
    public DeleteReservaResponse(Boolean resultado, String mensaje, Integer idReserva) {
        super();
        this.resultado = resultado;
        this.mensaje = mensaje;
        this.idReserva = idReserva;
    }

    public Boolean getResultado() {
        return resultado;
    }

    public void setResultado(Boolean resultado) {
        this.resultado = resultado;
    }

    public DeleteReservaResponse withResultado(Boolean resultado) {
        this.resultado = resultado;
        return this;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public DeleteReservaResponse withMensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public DeleteReservaResponse withIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
        return this;
    }

}
