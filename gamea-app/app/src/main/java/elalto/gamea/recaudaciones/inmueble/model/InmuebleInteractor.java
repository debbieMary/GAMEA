package elalto.gamea.recaudaciones.inmueble.model;

import elalto.gamea.recaudaciones.entities.Inmueble;
import elalto.network.entities.TokenManager;

public interface InmuebleInteractor {
    interface onInmuebleFinishedListener {
        void onSuccess(Inmueble inmueble);

        void onFailed(String message);
    }

    void findInmueble(String tipo_doc, String nro_doc, TokenManager tokenManager, onInmuebleFinishedListener listener);
}
