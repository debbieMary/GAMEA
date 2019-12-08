package elalto.gamea.map.canchas.model;

import java.util.List;

import elalto.gamea.map.canchas.entities.CanchaInfo;

public interface CanchaReservaInteractor {
    interface onCanchasReservaFinishedListener {
        void onSuccess(String message);

        void onFailed(String message);
    }

    void saveCanchasReserva(String reserva, onCanchasReservaFinishedListener listener);
}
