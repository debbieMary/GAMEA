package elalto.network.canchas.entities;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeleteReservaBody {

    @SerializedName("estado")
    @Expose
    private Integer estado;
    @SerializedName("fecha_update")
    @Expose
    private String fechaUpdate;
    @SerializedName("id_reserva")
    @Expose
    private Integer idReserva;
    @SerializedName("id_usuario")
    @Expose
    private String idUsuario;

    /**
     * No args constructor for use in serialization
     *
     */
    public DeleteReservaBody() {
    }

    /**
     *
     * @param estado
     * @param idUsuario
     * @param fechaUpdate
     * @param idReserva
     */
    public DeleteReservaBody(Integer estado, String fechaUpdate, Integer idReserva, String idUsuario) {
        super();
        this.estado = estado;
        this.fechaUpdate = fechaUpdate;
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public DeleteReservaBody withEstado(Integer estado) {
        this.estado = estado;
        return this;
    }

    public String getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(String fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    public DeleteReservaBody withFechaUpdate(String fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
        return this;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public DeleteReservaBody withIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
        return this;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public DeleteReservaBody withIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

}
