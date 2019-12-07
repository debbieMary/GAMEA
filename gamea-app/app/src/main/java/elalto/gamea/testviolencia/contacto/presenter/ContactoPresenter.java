package elalto.gamea.testviolencia.contacto.presenter;

import elalto.network.entities.TokenManager;

public interface ContactoPresenter {
    void send_mensaje(String mensaje, String email, Double lat, Double lng, TokenManager tokenManager);
    void onDestroy();
}
