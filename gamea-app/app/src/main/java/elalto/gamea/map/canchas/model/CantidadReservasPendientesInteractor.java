package elalto.gamea.map.canchas.model;

import java.util.List;

import elalto.network.canchas.entities.IdUsuarioBody;

public interface CantidadReservasPendientesInteractor {
  interface onCantidadReservasPendientesFinishedListener {
    void onSuccessCantidadReservasPendientes(int cantidad);

    void onFailedCantidadReservasPendientes(String message);
  }

  void getCantidadReservasPendientes(IdUsuarioBody idUsuarioBody, CantidadReservasPendientesInteractor.onCantidadReservasPendientesFinishedListener listener);
}
