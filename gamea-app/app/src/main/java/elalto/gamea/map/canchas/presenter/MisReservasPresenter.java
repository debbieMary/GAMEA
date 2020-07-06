package elalto.gamea.map.canchas.presenter;

import elalto.network.canchas.entities.MisReservasBody;

public interface MisReservasPresenter {
    void getMisReservas(MisReservasBody misReservasBody);
    void onDestroy();
}
