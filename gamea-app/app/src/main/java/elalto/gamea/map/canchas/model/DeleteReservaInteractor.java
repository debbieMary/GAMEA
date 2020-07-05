package elalto.gamea.map.canchas.model;

import java.util.List;

import elalto.network.canchas.entities.DeleteReservaBody;
import elalto.network.canchas.entities.DeleteReservaResponse;
import elalto.network.entities.TokenManager;

public interface DeleteReservaInteractor {
  interface onDeleteReservaFinishedListener {
    void onSuccess(DeleteReservaResponse deleteReservaResponse);

    void onFailed(String message);
  }

  void deleteReservaCancha(DeleteReservaBody deleteReservaBody, DeleteReservaInteractor.onDeleteReservaFinishedListener listener);
}
