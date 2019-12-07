package elalto.gamea.recaudaciones.patente.view;

import elalto.gamea.recaudaciones.entities.Patente;

public interface PatenteView {
    void showProgress();

    void hideProgress();

    void showResponse(Patente patente);

    void showErrorMessage(String message);
}
