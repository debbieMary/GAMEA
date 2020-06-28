package elalto.gamea.map.canchas.presenter;

import elalto.network.canchas.entities.DeleteReservaBody;
import elalto.network.entities.TokenManager;

public interface DeleteReservaPresenter {
  void deleteReserva(DeleteReservaBody deleteReservaBody);
  void onDestroy();
}
