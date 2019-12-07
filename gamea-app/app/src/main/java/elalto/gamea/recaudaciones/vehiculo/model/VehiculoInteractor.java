package elalto.gamea.recaudaciones.vehiculo.model;

import elalto.gamea.recaudaciones.entities.Vehiculo;
import elalto.network.entities.TokenManager;

public interface VehiculoInteractor {
    interface onVehiculoFinishedListener {
        void onSuccess(Vehiculo vehiculo);

        void onFailed(String message);
    }

    void findVehiculo(String tipo_doc, String nro_doc, TokenManager tokenManager, onVehiculoFinishedListener listener);
}
