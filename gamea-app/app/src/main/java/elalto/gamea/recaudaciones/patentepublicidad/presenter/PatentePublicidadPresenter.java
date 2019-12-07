package elalto.gamea.recaudaciones.patentepublicidad.presenter;

import elalto.network.entities.TokenManager;

public interface PatentePublicidadPresenter {
    void findPatente(String tipo_doc, String nro_doc, TokenManager tokenManager);
    void  onDestroy();
}
