package elalto.gamea.map.canchas.presenter;

import elalto.network.entities.TokenManager;

public interface CanchasInfoPresenter {
    void getCanchasInfo(String id_cancha);
    void onDestroy();
}
