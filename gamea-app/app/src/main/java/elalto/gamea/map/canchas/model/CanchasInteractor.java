package elalto.gamea.map.canchas.model;

import java.util.List;

import elalto.gamea.map.canchas.entities.Cancha;
import elalto.network.entities.TokenManager;

public interface CanchasInteractor {
    interface onCanchasFinishedListener {
        void onSuccess(List<Cancha> canchaList);

        void onFailed(String message);
    }

    void getCanchas(TokenManager tokenManager, onCanchasFinishedListener listener);
}
