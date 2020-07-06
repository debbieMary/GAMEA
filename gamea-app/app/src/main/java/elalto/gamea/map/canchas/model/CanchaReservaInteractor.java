package elalto.gamea.map.canchas.model;

import java.util.List;

import elalto.network.canchas.entities.ReservaBody;


public interface CanchaReservaInteractor {
    interface onCanchasReservaFinishedListener {
        void onSuccess(String message);

        void onFailed(String message);
    }

    void saveCanchasReserva(ReservaBody reservaBody, onCanchasReservaFinishedListener listener);
}
