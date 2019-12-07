package elalto.gamea.testviolencia.contacto.model;

import elalto.network.entities.TokenManager;

public interface ContactoInteractor {
    interface onContactoFinishedListener {
        void onSuccess(String message);

        void onFailed(String message);
    }

    void enviarMensaje(String mensaje, String email, Double lat, Double lng, TokenManager tokenManager, onContactoFinishedListener listener);
}
