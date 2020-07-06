package elalto.network.canchas.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CantidadReserva {

    @SerializedName("cantidad")
    @Expose
    private Integer cantidad;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CantidadReserva() {
    }

    /**
     * 
     * @param cantidad
     */
    public CantidadReserva(Integer cantidad) {
        super();
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public CantidadReserva withCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }

}
