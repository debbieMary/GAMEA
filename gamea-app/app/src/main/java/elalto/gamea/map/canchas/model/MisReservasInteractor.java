package elalto.gamea.map.canchas.model;

import java.util.List;
import elalto.network.canchas.entities.MisReservas;
import elalto.network.canchas.entities.MisReservasBody;

public interface MisReservasInteractor {
    interface onMisReservasFinishedListener {
        void onSuccess(List<MisReservas> misReservas);

        void onFailed(String message);
    }
    void getMisReservas(MisReservasBody misReservasBody, onMisReservasFinishedListener listener);
}
