package elalto.gamea.recaudaciones.inmueble.presenter;

import elalto.network.entities.TokenManager;

public interface InmueblePresenter {
    void findInmueble(String tipo_doc, String nro_doc, TokenManager tokenManager);
    void  onDestroy();
}
