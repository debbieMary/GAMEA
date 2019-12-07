package elalto.gamea.recaudaciones.patente.presenter;

import elalto.network.entities.TokenManager;

public interface PatentePresenter {
    void findPatente(String tipo_doc, String nro_doc, TokenManager tokenManager);
    void onDestroy();
}
