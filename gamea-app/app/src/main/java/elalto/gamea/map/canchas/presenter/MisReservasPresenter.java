package elalto.gamea.map.canchas.presenter;

import elalto.network.canchas.entities.IdUsuarioBody;

public interface MisReservasPresenter {
    void getMisReservas(IdUsuarioBody idUsuarioBody);
    void onDestroy();
}
