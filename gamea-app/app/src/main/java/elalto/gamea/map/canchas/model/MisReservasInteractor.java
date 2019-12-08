package elalto.gamea.map.canchas.model;

import java.util.List;
import elalto.gamea.map.canchas.entities.MisReservas;

public interface MisReservasInteractor {
    interface onMisReservasFinishedListener {
        void onSuccess(List<MisReservas> misReservas);

        void onFailed(String message);
    }
    void getMisReservas(String id_usuario, onMisReservasFinishedListener listener);
}
