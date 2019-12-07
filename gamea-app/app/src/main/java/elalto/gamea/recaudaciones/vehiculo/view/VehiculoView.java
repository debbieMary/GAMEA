package elalto.gamea.recaudaciones.vehiculo.view;

import elalto.gamea.recaudaciones.entities.Vehiculo;

public interface VehiculoView {
    void showProgress();

    void hideProgress();

    void showResponse(Vehiculo vehiculo);

    void showErrorMessage(String message);
}
