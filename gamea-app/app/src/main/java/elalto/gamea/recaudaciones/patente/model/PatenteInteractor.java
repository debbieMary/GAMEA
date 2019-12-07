package elalto.gamea.recaudaciones.patente.model;

import elalto.gamea.recaudaciones.entities.Patente;
import elalto.network.entities.TokenManager;

public interface PatenteInteractor {
    interface onPatenteFinishedListener {
        void onSuccess(Patente patente);

        void onFailed(String message);
    }

    void findPatente(String tipo_doc, String nro_doc, TokenManager tokenManager, onPatenteFinishedListener listener);
}
