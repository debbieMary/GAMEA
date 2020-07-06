package elalto.gamea.map.canchas.presenter;

import elalto.network.canchas.entities.ReservaBody;

public interface CanchaReservaPresenter {
    void saveCanchasReserva(ReservaBody reservaBody);
    void onDestroy();
}
