package elalto.gamea.catastro.consulta_tramite.model;

import elalto.gamea.catastro.consulta_tramite.entities.Tramite;

public interface ConsultaTramiteInteractor {
    interface onConsultaTramiteFinishedListener {
        void onSuccess(Tramite tramite);
        void setErrorConsulta(String message);
        void onFailed(String message);
    }
    void getTramite(String tramite, String tipo, onConsultaTramiteFinishedListener listener);
}
