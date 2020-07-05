package elalto.gamea.map.canchas.model;

import java.util.List;

import elalto.network.canchas.entities.CanchaInfo;

public interface CanchasInfoInteractor {
    interface onCanchasInfoFinishedListener {
        void onSuccess(List<CanchaInfo> canchaInfo);

        void onFailed(String message);
    }

    void getCanchasInfo(String id_cancha, onCanchasInfoFinishedListener listener);
}
