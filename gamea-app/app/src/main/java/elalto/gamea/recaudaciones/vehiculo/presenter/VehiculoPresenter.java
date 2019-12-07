package elalto.gamea.recaudaciones.vehiculo.presenter;

import elalto.network.entities.TokenManager;

public interface VehiculoPresenter {
    void getVehiculo(String tipo_doc, String nro_doc, TokenManager tokenManager);

    void onDestroy();
}
