package elalto.gamea.recaudaciones.inmueble.view;

import elalto.gamea.recaudaciones.entities.Inmueble;

public interface InmuebleView {
    void showProgress();

    void hideProgress();

    void showResponse(Inmueble inmueble);

    void showErrorMessage(String message);
}
