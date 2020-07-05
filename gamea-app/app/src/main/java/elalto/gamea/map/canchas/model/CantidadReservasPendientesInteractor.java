package elalto.gamea.map.canchas.model;

import java.util.List;

import elalto.network.entities.TokenManager;

public interface CantidadReservasPendientesInteractor {
  interface onCantidadReservasPendientesFinishedListener {
    void onSuccessCantidadReservasPendientes(int cantidad);

    void onFailedCantidadReservasPendientes(String message);
  }

  void getCantidadReservasPendientes(String id_usuario, CantidadReservasPendientesInteractor.onCantidadReservasPendientesFinishedListener listener);
}
