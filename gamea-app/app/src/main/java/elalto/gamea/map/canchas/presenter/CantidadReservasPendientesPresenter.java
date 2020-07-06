package elalto.gamea.map.canchas.presenter;

import elalto.network.canchas.entities.IdUsuarioBody;

public interface CantidadReservasPendientesPresenter {
    void getCantidadReservasPendientes(IdUsuarioBody id_usuario);
    void onDestroy();
}


