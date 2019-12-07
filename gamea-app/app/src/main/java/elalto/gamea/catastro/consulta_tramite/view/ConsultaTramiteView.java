package elalto.gamea.catastro.consulta_tramite.view;

import elalto.gamea.catastro.consulta_tramite.entities.Tramite;

public interface ConsultaTramiteView {
    void showProgress();
    void hideProgress();
    void showErrorMessage(String message);
    void setErrorConsulta(String message);
    void getDtm(Tramite tramite);
}
